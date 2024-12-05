package br.com.gume.springbootcleanarch.infrastructure.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gume.springbootcleanarch.application.usecases.CreateUserInteractor;
import br.com.gume.springbootcleanarch.domain.entity.User;

@RestController
@RequestMapping("users")
public class UserController {
    private final CreateUserInteractor createUserInteractor;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserInteractor createUserInteractor, UserDTOMapper userDTOMapper) {
        this.createUserInteractor = createUserInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    CreateUserResponse create(@RequestBody CreateUserRequest request) {
        User userBusinessObj = userDTOMapper.toUser(request);
        createUserInteractor.createUser(userBusinessObj);
        return userDTOMapper.toResponse(userBusinessObj);
    }
}
