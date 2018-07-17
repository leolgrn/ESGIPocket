package controller.menu.course;

import data.model.Course;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class CourseListCell {

    @FXML
    public AnchorPane anchorPane;
    @FXML
    public Text lessonTitle;
    @FXML
    public Text lessonTopic;
    @FXML
    public Text lessonAuthor;
    @FXML
    public Text like;
    @FXML
    public Text dislike;
    @FXML
    public Text description;

    public CourseListCell() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/course/courseCustomCell.fxml"));
        fxmlLoader.setController(this);
        try
        {
            anchorPane = fxmlLoader.load();
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
        lessonAuthor.setText(course.getUser().getFirstname() + " " + course.getUser().getLastname());
        like.setText(Integer.toString(course.getLike()));
        dislike.setText(Integer.toString(course.getDislike()));
    }

    public AnchorPane getPane(){
        return anchorPane;
    }
}
