package controller.menu.quizzes;

import data.model.Quiz;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class QuizValidationController {

    private BorderPane borderPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text succesMessage;

    @FXML
    private Button newQuiz;

    public QuizValidationController(BorderPane borderPane, Quiz quiz) {
        this.borderPane = borderPane;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/quiz/quizValidation.fxml"));
        fxmlLoader.setController(this);
        try
        {
            this.anchorPane = fxmlLoader.load();
            this.anchorPane.getStylesheets().add(getClass().getResource("/menu/css/listViewContent.css").toExternalForm());
            setInfo(quiz);
            this.borderPane = borderPane;
            Platform.runLater(() -> {
                borderPane.setCenter(this.anchorPane);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setInfo(Quiz quiz){
        String user = quiz.getUser().getFirstname();
        succesMessage.setText("Le quiz a bien été créé.\nMerci pour ta contibution " + user + " !");
        newQuiz.setOnMouseClicked(event -> {
            new QuizCreationController(borderPane);
        });
    }
}
