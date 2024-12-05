package br.com.gume.springbootcleanarch.application.usecases;

import br.com.gume.springbootcleanarch.application.gateways.UserGateway;
import br.com.gume.springbootcleanarch.domain.entity.User;

public class CreateUserInteractor {
    private UserGateway userGateway;

    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user) {
        return userGateway.creatUser(user);
    }
}
