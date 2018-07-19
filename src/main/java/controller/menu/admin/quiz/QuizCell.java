package controller.menu.admin.quiz;

import data.model.Quiz;
import javafx.application.Platform;
import javafx.scene.control.ListCell;

public class QuizCell extends ListCell<Quiz> {
    @Override
    public void updateItem(Quiz quiz, boolean empty)
    {
        super.updateItem(quiz, empty);
        if(quiz != null){
            QuizListCell quizListCell = new QuizListCell();
            quizListCell.setInfo(quiz);
            Platform.runLater(() -> {
                setGraphic(quizListCell.getAnchorPane());
            });
        }
    }
}
