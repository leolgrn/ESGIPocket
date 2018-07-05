package data.dto.mapper;

import data.dto.EUser;
import data.model.User;
import interfaces.Mapping;

public class UserMapper implements Mapping<User, EUser> {

    @Override
    public User map(EUser item) {
        User user = new User();

        user.setFirstname(item.getFirstname());
        user.setLastname(item.getLastname());
        user.setEmail(item.getEmail());
        user.setPassword(item.getPassword());
        user.setActivationCode(item.getActivationCode());
        user.setActivated(item.getActivated());
        user.setRole(item.getRole());
        user.setClassId(item.getClassId());

        return user;
    }
}
