package controller.menu.home;

import controller.menu.course.CourseCell;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Course;
import data.model.User;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class HomeController {

    private ESGIPocketProvider esgiPocketProvider;

    private BorderPane borderPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text hello;

    @FXML
    private Text classe;


    @FXML
    private Text course;

    @FXML
    private Text day;

    @FXML
    private Text time;

    @FXML
    private Text room;

    @FXML
    private Text progression;

    @FXML
    private ListView<Course> courseListView;

    public HomeController(BorderPane borderPane) {
        this.borderPane = borderPane;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/home/HomeBorderPane.fxml"));
        fxmlLoader.setController(this);
        esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        try
        {
            anchorPane = fxmlLoader.load();
            anchorPane.getStylesheets().add(getClass().getResource("/menu/css/listViewContent.css").toExternalForm());
            setInfo();
            borderPane.setCenter(anchorPane);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(){
        User user = Authentification.getInstance().getUser();
        hello.setText("Hello " + user.getFirstname() + " !");
        classe.setText(user.getClasse().getSpeciality().getAcronym() + " - " + user.getClasse().getGroup().getName());
        setListView();
        //setPlanning();
    }

    public void setListView(){
        esgiPocketProvider.getCourseLikedByUser(new ApiListener<ArrayList<Course>>() {
            @Override
            public void onSuccess(ArrayList<Course> response) {
                ObservableList<Course> observableList = FXCollections.observableArrayList(response);
                courseListView.setItems(observableList);
                courseListView.setCellFactory(listView -> new CourseCell());
                Platform.runLater(() -> {
                    courseListView.getStylesheets().add(getClass().getResource("/menu/css/courseListView.css").toExternalForm());
                });
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
