package controller.menu.admin.group;

import data.model.Group;
import javafx.application.Platform;
import javafx.scene.control.ListCell;

public class GroupCell extends ListCell<Group> {
    @Override
    public void updateItem(Group group, boolean empty)
    {
        super.updateItem(group, empty);
        if(group != null){
            GroupListCell groupListCell = new GroupListCell();
            groupListCell.setInfo(group);
            Platform.runLater(() -> {
                setGraphic(groupListCell.getPane());
            });
        }
    }
}
