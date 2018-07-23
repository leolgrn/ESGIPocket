package controller.menu.admin.topic;

import data.model.Topic;
import javafx.application.Platform;
import javafx.scene.control.ListCell;

public class TopicCell extends ListCell<Topic> {
    @Override
    public void updateItem(Topic topic, boolean empty)
    {
        super.updateItem(topic, empty);
        if(topic != null){
            TopicListCell topicListCell = new TopicListCell();
            topicListCell.setInfo(topic);
            Platform.runLater(() -> {
                setGraphic(topicListCell.getPane());
            });
        }
    }
}
