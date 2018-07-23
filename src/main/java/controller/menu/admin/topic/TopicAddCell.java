package controller.menu.admin.topic;

import data.mainapi.post.ESGIPocketProviderPost;
import data.model.Authentification;
import data.model.Topic;
import data.model.credentials.TopicCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class TopicAddCell {

    private ESGIPocketProviderPost esgiPocketProviderPost;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField name;

    @FXML
    private Button add;

    public TopicAddCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/TopicAddCell.fxml"));
        fxmlLoader.setController(this);
        esgiPocketProviderPost = new ESGIPocketProviderPost(Authentification.getInstance().getToken());
        try{
            anchorPane = fxmlLoader.load();
            anchorPane.getStylesheets().add(getClass().getResource("/menu/css/addCell.css").toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public Button getAdd() {
        return add;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    public ESGIPocketProviderPost getEsgiPocketProviderPost() {
        return esgiPocketProviderPost;
    }

    public void setEsgiPocketProviderPost(ESGIPocketProviderPost esgiPocketProviderPost) {
        this.esgiPocketProviderPost = esgiPocketProviderPost;
    }

    public void setAddCell(){
        getName().setPromptText("Nom");
        getAdd().setOnMouseClicked(event -> {
            TopicCredentials topicCredentials = new TopicCredentials(getName().getText());
            getEsgiPocketProviderPost().postTopic(topicCredentials, new ApiListener<Topic>() {

                @Override
                public void onSuccess(Topic response) {
                    getName().setText("");
                    Scene currentScene = getAnchorPane().getScene();
                    Platform.runLater(() -> {
                        TopicListViewController topicListViewController = new TopicListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
                        topicListViewController.setListView();
                    });
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }
}
