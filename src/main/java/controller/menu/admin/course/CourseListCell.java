package controller.menu.admin.course;

import data.mainapi.delete.ESGIPocketProviderDelete;
import data.model.Authentification;
import data.model.Course;
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

public class CourseListCell {

    private ESGIPocketProviderDelete esgiPocketProviderDelete;

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
        esgiPocketProviderDelete = new ESGIPocketProviderDelete(Authentification.getInstance().getToken());
        try
        {
            anchorPane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(Course course) {
        title.setText(course.getTitle());
        topic.setText(course.getTopic().getName());
        speciality.setText(course.getClasse().getSpeciality().getName());
        group.setText(course.getClasse().getGroup().getName());
        year.setText(course.getClasse().getYear().getName());
        delete.setOnMouseClicked(event -> {
            esgiPocketProviderDelete.deleteCourse(course.getId(), new ApiListener<String>() {
                @Override
                public void onSuccess(String response) {
                    Scene currentScene = getPane().getScene();
                    Platform.runLater(() -> {
                        CourseListViewController courseListViewController = new CourseListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
                        courseListViewController.setListView();
                    });
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    public AnchorPane getPane(){
        return anchorPane;
    }
}
