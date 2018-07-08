package data.dto.mapper;

import data.dto.EGroup;
import data.model.Group;
import interfaces.Mapping;

public class GroupMapper implements Mapping<Group, EGroup> {
    @Override
    public Group map(EGroup item) {
        Group group = new Group();
        group.setName(item.getName());
        group.setNumber(item.getNumber());
        return group;
    }
}
