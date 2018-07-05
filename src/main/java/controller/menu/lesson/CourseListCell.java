package controller.menu.lesson;

import data.model.Course;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class CourseListCell {

    @FXML
    public Pane pane;
    @FXML
    public Text lessonTitle;
    @FXML
    public Text lessonTopic;
    @FXML
    public Text lessonAuthor;
    @FXML
    public Text description;

    public CourseListCell() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/lessonCustomCell.fxml"));
        fxmlLoader.setController(this);
        try
        {
            pane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(Course course)
    {
        lessonTitle.setText(course.getTitle());
        lessonTopic.setText(course.getTopic().getName());
        lessonAuthor.setText(course.getUpdatedAt());
    }

    public Pane getPane(){
        return pane;
    }
}
