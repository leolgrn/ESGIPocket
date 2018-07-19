package controller.menu.admin.topic;

import abstractclass.SingleFieldListCell;
import data.model.Topic;
import data.model.credentials.TopicCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class TopicListCell extends SingleFieldListCell<Topic> {
    @Override
    public void setInfo(Topic object) {
        getName().setText(object.getName());
        getDelete().setOnMouseClicked(event -> {
            getEsgiPocketProviderDelete().deleteTopic(object.getId(), new ApiListener<String>() {
                @Override
                public void onSuccess(String response) {
                    reload();
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
        getUpdate().setOnMouseClicked(event -> {
            String name = getName().getText();
            TopicCredentials topicCredentials = new TopicCredentials(name);
            getEsgiPocketProviderPut().updateTopic(topicCredentials, object.getId(), new ApiListener<Topic>() {
                @Override
                public void onSuccess(Topic response) {
                    reload();
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    @Override
    public void reload() {
        Scene currentScene = getPane().getScene();
        Platform.runLater(() -> {
            TopicListViewController topicListViewController = new TopicListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
            topicListViewController.setListView();
        });
    }


}
