package br.com.gume.springbootcleanarch.infrastructure.gateways;

import br.com.gume.springbootcleanarch.application.gateways.UserGateway;
import br.com.gume.springbootcleanarch.domain.entity.User;
import br.com.gume.springbootcleanarch.infrastructure.persistence.UserEntity;
import br.com.gume.springbootcleanarch.infrastructure.persistence.UserRepository;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User creatUser(User userDomainObj) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
        UserEntity savedObj = userRepository.save(userEntity);

        return userEntityMapper.toDomainObj(savedObj);
    }

}
