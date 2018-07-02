package data.dto.mapper;

import data.dto.EAuthentification;
import data.model.Authentification;

public class AuthentificationMapper {

    public Authentification map(EAuthentification eAuthentification){
        Authentification authentification = Authentification.getInstance();
        UserMapper userMapper = new UserMapper();

        authentification.setToken(eAuthentification.getToken());
        authentification.setUser(userMapper.map(eAuthentification.geteUser()));

        return authentification;
    }
}
