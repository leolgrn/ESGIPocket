package data.dto.mapper;

import data.dto.EGroup;
import data.model.Group;
import interfaces.ArrayListMapping;

import java.util.ArrayList;

public class GroupListMapper implements ArrayListMapping<Group, EGroup> {
    @Override
    public ArrayList<Group> map(ArrayList<EGroup> arrayList) {
        ArrayList<Group> groupArrayList = new ArrayList<>();
        for(EGroup eGroup: arrayList){
            Group group = new Group();
            group.setName(eGroup.getName());
            group.setNumber(eGroup.getNumber());
            groupArrayList.add(group);
        }
        return groupArrayList;
    }
}
