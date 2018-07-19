package controller.menu.admin.classes;

import data.model.Class;
import data.model.User;
import javafx.application.Platform;
import javafx.scene.control.ListCell;

public class ClassCell extends ListCell<Class> {

    @Override
    public void updateItem(Class newClass, boolean empty)
    {
        super.updateItem(newClass, empty);
        if(newClass != null){
            ClassListCell classListCell = new ClassListCell();
            classListCell.setCell(newClass);
            Platform.runLater(() -> {
                setGraphic(classListCell.getAnchorPane());
            });
        }
    }
}
