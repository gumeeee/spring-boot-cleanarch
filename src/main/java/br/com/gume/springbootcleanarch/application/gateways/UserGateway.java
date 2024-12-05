package br.com.gume.springbootcleanarch.application.gateways;

import br.com.gume.springbootcleanarch.domain.entity.User;

public interface UserGateway {
    User creatUser(User user);
}
