package controller.menu.quizzes;

import data.mainapi.post.ESGIPocketProviderPost;
import data.model.Authentification;
import data.model.Quiz;
import data.model.credentials.AnswerCredentials;
import data.model.credentials.QuestionAndAnswerCredentials;
import data.model.credentials.QuizCredentials;
import interfaces.ApiListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionCreationController {

    private QuizCredentials quizCredentials;

    private BorderPane borderPane;

    private ESGIPocketProviderPost esgiPocketProviderPost;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField question;

    @FXML
    private ChoiceBox<String> numberOfAnswer;

    @FXML
    private TextField response1;

    @FXML
    private TextField response2;

    @FXML
    private TextField response3;

    @FXML
    private TextField response4;

    @FXML
    private TextField response5;

    @FXML
    private RadioButton rightAnswer1;

    @FXML
    private RadioButton rightAnswer2;

    @FXML
    private RadioButton rightAnswer3;

    @FXML
    private RadioButton rightAnswer4;

    @FXML
    private RadioButton rightAnswer5;

    @FXML
    private Button addQuestion;

    @FXML
    private Button createQuiz;

    public QuestionCreationController(BorderPane borderPane, QuizCredentials quizCredentials) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/quiz/questionCreation.fxml"));
        fxmlLoader.setController(this);
        try
        {
            this.anchorPane = fxmlLoader.load();
            this.anchorPane.getStylesheets().add(getClass().getResource("/menu/css/listViewContent.css").toExternalForm());
            esgiPocketProviderPost = new ESGIPocketProviderPost(Authentification.getInstance().getToken());
            setInfo();
            this.quizCredentials = quizCredentials;
            this.borderPane = borderPane;
            borderPane.setCenter(this.anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setInfo(){
        setNumberOfAnswer();
        setAddQuestion();
        setCreateQuiz();
    }

    public void setNumberOfAnswer(){
        ObservableList<String> observableList = FXCollections.observableArrayList("3", "4", "5");
        numberOfAnswer.setItems(observableList);
        numberOfAnswer.setOnAction(event -> {
            switch (numberOfAnswer.getSelectionModel().getSelectedItem()){
                case "3":
                    response1.setVisible(true);
                    response2.setVisible(true);
                    response3.setVisible(true);
                    response4.setVisible(false);
                    response5.setVisible(false);
                    rightAnswer1.setVisible(true);
                    rightAnswer2.setVisible(true);
                    rightAnswer3.setVisible(true);
                    rightAnswer4.setVisible(false);
                    rightAnswer5.setVisible(false);
                    break;
                case "4":
                    response1.setVisible(true);
                    response2.setVisible(true);
                    response3.setVisible(true);
                    response4.setVisible(true);
                    response5.setVisible(false);
                    rightAnswer1.setVisible(true);
                    rightAnswer2.setVisible(true);
                    rightAnswer3.setVisible(true);
                    rightAnswer4.setVisible(true);
                    rightAnswer5.setVisible(false);
                    break;
                case "5":
                    response1.setVisible(true);
                    response2.setVisible(true);
                    response3.setVisible(true);
                    response4.setVisible(true);
                    response5.setVisible(true);
                    rightAnswer1.setVisible(true);
                    rightAnswer2.setVisible(true);
                    rightAnswer3.setVisible(true);
                    rightAnswer4.setVisible(true);
                    rightAnswer5.setVisible(true);
                    break;
                default:
                    response1.setVisible(true);
                    response2.setVisible(true);
                    response3.setVisible(true);
                    response4.setVisible(false);
                    response5.setVisible(false);
                    rightAnswer1.setVisible(true);
                    rightAnswer2.setVisible(true);
                    rightAnswer3.setVisible(true);
                    rightAnswer4.setVisible(false);
                    rightAnswer5.setVisible(false);
            }
        });
        numberOfAnswer.getSelectionModel().select(0);
    }

    public void setAddQuestion(){
        addQuestion.setOnMouseClicked(event -> {
            getInfo();
            new QuestionCreationController(this.borderPane, quizCredentials);
        });
    }

    public void setCreateQuiz(){
        createQuiz.setOnMouseClicked(event -> {
            getInfo();
            esgiPocketProviderPost.postQuiz(quizCredentials, new ApiListener<Quiz>() {
                @Override
                public void onSuccess(Quiz response) {
                   new QuizValidationController(borderPane, response);
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    public void getInfo(){
        String question = this.question.getText();
        ArrayList<AnswerCredentials> answerCredentials = new ArrayList<>();
        String response1 = this.response1.getText();
        String response2 = this.response2.getText();
        String response3 = this.response3.getText();
        String response4 = this.response4.getText();
        String response5 = this.response5.getText();
        Boolean rightAnswer1 = this.rightAnswer1.isSelected();
        Boolean rightAnswer2 = this.rightAnswer2.isSelected();
        Boolean rightAnswer3 = this.rightAnswer3.isSelected();
        Boolean rightAnswer4 = this.rightAnswer4.isSelected();
        Boolean rightAnswer5 = this.rightAnswer5.isSelected();
        AnswerCredentials answerCredentials1 = new AnswerCredentials(response1, rightAnswer1);
        AnswerCredentials answerCredentials2 = new AnswerCredentials(response2, rightAnswer2);
        AnswerCredentials answerCredentials3 = new AnswerCredentials(response3, rightAnswer3);
        AnswerCredentials answerCredentials4 = new AnswerCredentials(response4, rightAnswer4);
        AnswerCredentials answerCredentials5 = new AnswerCredentials(response5, rightAnswer5);
        switch (numberOfAnswer.getSelectionModel().getSelectedItem()){
            case "3":
                answerCredentials.add(answerCredentials1);
                answerCredentials.add(answerCredentials2);
                answerCredentials.add(answerCredentials3);
                break;
            case "4":
                answerCredentials.add(answerCredentials1);
                answerCredentials.add(answerCredentials2);
                answerCredentials.add(answerCredentials3);
                answerCredentials.add(answerCredentials4);
                break;
            case "5":
                answerCredentials.add(answerCredentials1);
                answerCredentials.add(answerCredentials2);
                answerCredentials.add(answerCredentials3);
                answerCredentials.add(answerCredentials4);
                answerCredentials.add(answerCredentials5);
                break;
            default:
                answerCredentials.add(answerCredentials1);
                answerCredentials.add(answerCredentials2);
                answerCredentials.add(answerCredentials3);
        }
        QuestionAndAnswerCredentials questionAndAnswerCredentials = new QuestionAndAnswerCredentials(question, answerCredentials);
        quizCredentials.getContent().add(questionAndAnswerCredentials);
    }
}
