package controller.menu.home;

import controller.core.Core;
import controller.menu.course.CourseCell;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Course;
import data.model.NextCourse;
import data.model.User;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HomeController {

    private ESGIPocketProvider esgiPocketProvider;

    private int numberOfCourse = 0;
    private int numberOfQuiz = 0;

    private BorderPane borderPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane planningAnchorPane;

    @FXML
    private Text hello;

    @FXML
    private Text classe;

    @FXML
    private Text course;

    @FXML
    private Text time;

    @FXML
    private Text teachers;

    @FXML
    private Button importPlanning;

    @FXML
    private Button importUpdatePlanning;

    @FXML
    private Text progression;

    @FXML
    private ListView<Course> courseListView;

    @FXML
    private Button deconnexion;

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
        planningAnchorPane.setVisible(false);
        importPlanning.setVisible(false);
        User user = Authentification.getInstance().getUser();
        hello.setText("Hello " + user.getFirstname() + " !");
        classe.setText(user.getClasse().getSpeciality().getAcronym() + " - " + user.getClasse().getGroup().getName());
        setListView();
        setProgression(user);
        setPlanning();
        setImportPlanning();
        setDeconnexion();
    }

    private void setImportPlanning() {
        importUpdatePlanning.setOnMouseClicked(event -> {
            // TODO : Import planning
        });
        importPlanning.setOnMouseClicked(event -> {
            // TODO : Import planning
        });
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

    public void setProgression(User user){
        esgiPocketProvider.getCourseUserContribution(user.getId(), new ApiListener<Integer>() {
            @Override
            public void onSuccess(Integer response) {
                numberOfCourse = response;
                getQuizz(user);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    public void getQuizz(User user){
        esgiPocketProvider.getQuizUserContribution(user.getId(), new ApiListener<Integer>() {
            @Override
            public void onSuccess(Integer response) {
                numberOfQuiz = response;
                displayInfos();
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    public void displayInfos(){
        int total = numberOfCourse + numberOfQuiz;
        String message = "";
        if(total >= 10){
            message = "Merci, vous êtes incroyable !";
        } else if(total > 5 && total < 10){
            message = "Félicitations !";
        } else {
            message = "Ne vous découragez pas ce n'est que le début !";
        }
        progression.setText("Vous avez pour l'instant créer " + numberOfCourse + " cours et " + numberOfQuiz + " quiz. " + message);
    }

    public void setPlanning(){
        esgiPocketProvider.getNextCourse(new ApiListener<NextCourse>() {
            @Override
            public void onSuccess(NextCourse response) {
                if(response == null){
                    importPlanning.setVisible(true);
                } else {
                    planningAnchorPane.setVisible(true);
                    course.setText(response.getSubject());
                    time.setText(response.getBeginning() + " - " + response.getEnd());
                    StringBuilder stringBuilder = new StringBuilder();
                    for(String teacher: response.getTeachers()){
                        stringBuilder.append(" " + teacher);
                    }
                    teachers.setText(stringBuilder.toString());
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    public void setDeconnexion(){
        deconnexion.setOnMouseClicked(event -> {
            Core core = new Core();
            try {
                core.start((Stage) borderPane.getScene().getWindow());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
