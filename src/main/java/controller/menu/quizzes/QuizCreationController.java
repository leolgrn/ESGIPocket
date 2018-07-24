package controller.menu.quizzes;

import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Topic;
import data.model.credentials.QuestionAndAnswerCredentials;
import data.model.credentials.QuizCredentials;
import interfaces.ApiListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.ArrayList;

public class QuizCreationController {

    private BorderPane borderPane;

    private ESGIPocketProvider esgiPocketProvider;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField name;

    @FXML
    private Button validation;

    @FXML
    private ChoiceBox<Topic> topic;

    public QuizCreationController(BorderPane borderPane) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/quiz/quizCreation.fxml"));
        fxmlLoader.setController(this);
        try
        {
            this.anchorPane = fxmlLoader.load();
            this.anchorPane.getStylesheets().add(getClass().getResource("/menu/css/listViewContent.css").toExternalForm());
            esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
            setInfo();
            this.borderPane = borderPane;
            borderPane.setCenter(this.anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setInfo(){
        setTopic();
        setValidation();
    }

    public void setTopic(){
        esgiPocketProvider.getTopics(new ApiListener<ArrayList<Topic>>() {
            @Override
            public void onSuccess(ArrayList<Topic> response) {
                ObservableList<Topic> observableList = FXCollections.observableArrayList(response);
                topic.setItems(observableList);
                topic.setConverter(new StringConverter<Topic>() {
                    @Override
                    public String toString(Topic object) {
                        return object.getName();
                    }

                    @Override
                    public Topic fromString(String string) {
                        return null;
                    }
                });
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public void setValidation(){

        validation.setOnMouseClicked(event -> {
            if(isValid()){
                String name = this.name.getText();
                String topic = this.topic.getSelectionModel().getSelectedItem().getId();
                ArrayList<QuestionAndAnswerCredentials> questionAndAnswerCredentialsArrayList = new ArrayList<>();
                QuizCredentials quizCredentials = new QuizCredentials(name, topic, questionAndAnswerCredentialsArrayList);
                QuestionCreationController questionCreationController = new QuestionCreationController(this.borderPane, quizCredentials);
            }
        });
    }

    public Boolean isValid(){
        return !this.name.getText().equals("") && this.topic.getSelectionModel().getSelectedItem() != null;
    }

}
