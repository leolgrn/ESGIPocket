package controller.menu.admin.quiz;

import data.mainapi.ESGIPocketProvider;
import data.mainapi.delete.ESGIPocketProviderDelete;
import data.mainapi.put.ESGIPocketProviderPut;
import data.model.Authentification;
import data.model.Quiz;
import data.model.Topic;
import data.model.credentials.QuizCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.ArrayList;

public class QuizListCell {

    private ESGIPocketProviderDelete esgiPocketProviderDelete;

    private ESGIPocketProviderPut esgiPocketProviderPut;

    private ESGIPocketProvider esgiPocketProvider;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text name;

    @FXML
    private ChoiceBox<Topic> topic;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    public QuizListCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/QuizListCell.fxml"));
        fxmlLoader.setController(this);
        String token = Authentification.getInstance().getToken();
        esgiPocketProviderDelete = new ESGIPocketProviderDelete(token);
        esgiPocketProviderPut = new ESGIPocketProviderPut(token);
        esgiPocketProvider = new ESGIPocketProvider(token);
        try
        {
            anchorPane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public ESGIPocketProviderDelete getEsgiPocketProviderDelete() {
        return esgiPocketProviderDelete;
    }

    public ESGIPocketProviderPut getEsgiPocketProviderPut() {
        return esgiPocketProviderPut;
    }

    public ESGIPocketProvider getEsgiPocketProvider() {
        return esgiPocketProvider;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public Text getName() {
        return name;
    }

    public ChoiceBox<Topic> getTopic() {
        return topic;
    }

    public Button getUpdate() {
        return update;
    }

    public Button getDelete() {
        return delete;
    }

    public void setInfo(Quiz quiz){
        setTopic(quiz);
        delete.setOnMouseClicked(event -> {
            getEsgiPocketProviderDelete().deleteQuiz(quiz.getId(), new ApiListener<String>() {
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
        update.setOnMouseClicked(event -> {
            String name = getName().getText();
            String topic = getTopic().getSelectionModel().getSelectedItem().getId();
            QuizCredentials quizCredentials = new QuizCredentials(name, topic);
            getEsgiPocketProviderPut().updateQuiz(quizCredentials, quiz.getId(), new ApiListener<Quiz>() {
                @Override
                public void onSuccess(Quiz response) {
                    reload();
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    public void setTopic(Quiz quiz){
        getEsgiPocketProvider().getTopics(new ApiListener<ArrayList<Topic>>() {
            @Override
            public void onSuccess(ArrayList<Topic> response) {
                ObservableList<Topic> observableList = FXCollections.observableArrayList(response);
                getTopic().setItems(observableList);
                getTopic().setConverter(new StringConverter<Topic>() {
                    @Override
                    public String toString(Topic object) {
                        return object.getName();
                    }

                    @Override
                    public Topic fromString(String string) {
                        return null;
                    }
                });
                Platform.runLater(() -> {
                    int index = 0;
                    for(int i = 0; i < topic.getItems().size(); i++){
                        if(topic.getItems().get(i).equals(quiz.getTopic())){
                            index = i;
                        }
                    }
                    topic.getSelectionModel().select(index);
                });
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    public void reload(){
        Scene currentScene = getAnchorPane().getScene();
        Platform.runLater(() -> {
            QuizListViewController quizListViewController = new QuizListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
            quizListViewController.setListView();
        });
    }

}
