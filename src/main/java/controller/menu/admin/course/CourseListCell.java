package controller.menu.admin.course;

import data.model.Course;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class CourseListCell {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text title;

    @FXML
    private Text topic;

    @FXML
    private Text speciality;

    @FXML
    private Text group;

    @FXML
    private Text year;

    @FXML
    private Button delete;

    public CourseListCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/CourseListCell.fxml"));
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
        title.setText(course.getTitle());
        topic.setText(course.getTopic().getName());
        speciality.setText(course.getClasse().getSpeciality().getName());
        group.setText(course.getClasse().getGroup().getName());
        year.setText(course.getClasse().getYear().getName());
    }

    public AnchorPane getPane(){
        return anchorPane;
    }
}
