package controller.menu.admin.group;

import abstractclass.SingleFieldListCell;
import data.model.Group;

public class GroupListCell extends SingleFieldListCell<Group> {
    @Override
    public void setInfo(Group object) {
        super.getName().setText(object.getName());
    }
}
