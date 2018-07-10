package controller.menu.admin.topic;

import abstractclass.SingleFieldListCell;
import data.model.Topic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class TopicListCell extends SingleFieldListCell<Topic> {
    @Override
    public void setInfo(Topic object) {
        super.getName().setText(object.getName());
    }
}
