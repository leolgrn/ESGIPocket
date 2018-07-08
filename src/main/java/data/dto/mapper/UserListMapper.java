package data.dto.mapper;

import data.dto.EUser;
import data.model.User;
import interfaces.ArrayListMapping;

import java.util.ArrayList;

public class UserListMapper implements ArrayListMapping<User, EUser> {

    @Override
    public ArrayList<User> map(ArrayList<EUser> arrayList) {
        ArrayList<User> userArrayList = new ArrayList<>();
        for (EUser eUser: arrayList){
            User user = new User();

            user.setFirstname(eUser.getFirstname());
            user.setLastname(eUser.getLastname());
            user.setEmail(eUser.getEmail());
            user.setPassword(eUser.getPassword());
            //user.setActivationCode(eUser.getActivationCode());
            user.setActivated(eUser.getActivated());
            user.setRole(eUser.getRole());
            user.setClassId(eUser.getClassId());
            user.setId(eUser.getId());

            userArrayList.add(user);
        }
        return userArrayList;
    }
}
