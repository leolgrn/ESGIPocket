package data.dto.mapper;

import data.dto.EUser;
import data.model.User;

public class UserMapper {

    public User map(EUser eUser){
        User user = new User();

        user.setFirstname(eUser.getFirstname());
        user.setLastname(eUser.getLastname());
        user.setEmail(eUser.getEmail());
        user.setPassword(eUser.getPassword());
        user.setActivationCode(eUser.getActivationCode());
        user.setActivated(eUser.getActivated());
        user.setRole(eUser.getRole());
        user.setClassId(eUser.getClassId());

        return user;
    }
}
