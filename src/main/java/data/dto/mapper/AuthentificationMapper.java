package data.dto.mapper;

import data.dto.EAuthentification;
import data.model.Authentification;
import interfaces.Mapping;

public class AuthentificationMapper implements Mapping<Authentification, EAuthentification> {

    @Override
    public Authentification map(EAuthentification item) {
        Authentification authentification = Authentification.getInstance();
        UserMapper userMapper = new UserMapper();

        authentification.setToken(item.getToken());
        authentification.setUser(userMapper.map(item.geteUser()));

        return authentification;
    }
}
