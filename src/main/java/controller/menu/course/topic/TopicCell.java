package controller.menu.course.topic;

import data.model.Topic;
import javafx.scene.control.ListCell;

public class TopicCell extends ListCell<Topic> {
    @Override
    protected void updateItem(Topic item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null || item.getName() == null) {
            setText(null);
        } else {
            setText(item.getName());
        }
    }
}