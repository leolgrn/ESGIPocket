package controller.menu.admin;

import data.model.User;
import javafx.application.Platform;
import javafx.scene.control.ListCell;

public class UserCell extends ListCell<User> {

    @Override
    public void updateItem(User user, boolean empty)
    {
        super.updateItem(user, empty);
        if(user != null){
            UserListCell userListCell = new UserListCell();
            userListCell.setInfo(user);
            Platform.runLater(() -> {
                setGraphic(userListCell.getPane());
            });
        }
    }
}
