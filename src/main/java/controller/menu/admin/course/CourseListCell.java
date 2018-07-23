package controller.menu.admin.course;

import data.mainapi.ESGIPocketProvider;
import data.mainapi.delete.ESGIPocketProviderDelete;
import data.mainapi.put.ESGIPocketProviderPut;
import data.model.Authentification;
import data.model.Course;
import data.model.Topic;
import data.model.credentials.CourseCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.ArrayList;

public class CourseListCell {

    private ESGIPocketProvider esgiPocketProvider;

    private ESGIPocketProviderDelete esgiPocketProviderDelete;

    private ESGIPocketProviderPut esgiPocketProviderPut;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField title;

    @FXML
    private ChoiceBox<Topic> topic;

    @FXML
    private ChoiceBox<String> archive;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    public CourseListCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/CourseListCell.fxml"));
        fxmlLoader.setController(this);
        String token = Authentification.getInstance().getToken();
        esgiPocketProviderDelete = new ESGIPocketProviderDelete(token);
        esgiPocketProviderPut = new ESGIPocketProviderPut(token);
        esgiPocketProvider = new ESGIPocketProvider(token);
        try
        {
            anchorPane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public AnchorPane getPane(){
        return anchorPane;
    }

    public TextField getTitle() {
        return title;
    }

    public ChoiceBox<Topic> getTopic() {
        return topic;
    }

    public ChoiceBox<String> getArchive() {
        return archive;
    }

    public void setInfo(Course course) {
        title.setText(course.getTitle());
        setTopic(course);
        setArchive(course);
        delete.setOnMouseClicked(event -> {
            esgiPocketProviderDelete.deleteCourse(course.getId(), new ApiListener<String>() {
                @Override
                public void onSuccess(String response) {
                   reload();
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
        update.setOnMouseClicked(event -> {
            String title = getTitle().getText();
            String topic = getTopic().getSelectionModel().getSelectedItem().getId();
            Boolean archive = null;
            if(getArchive().getSelectionModel().getSelectedItem().equals("Archive")) archive = true;
            else archive = false;
            CourseCredentials courseCredentials = new CourseCredentials(title, topic, archive);
            esgiPocketProviderPut.updateCourse(courseCredentials, course.getId(), new ApiListener<Course>() {
                @Override
                public void onSuccess(Course response) {
                    reload();
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    public void setTopic(Course course){
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
                Platform.runLater(() -> {
                    int index = 0;
                    for(int i = 0; i < topic.getItems().size(); i++){
                        if(topic.getItems().get(i).equals(course.getTopic())){
                            index = i;
                        }
                    }
                    topic.getSelectionModel().select(index);
                });
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    public void setArchive(Course course){
        ObservableList<String> observableList = FXCollections.observableArrayList("Archive", "En cours");
        archive.setItems(observableList);
        if(course.getArchive()) archive.getSelectionModel().select(0);
        else archive.getSelectionModel().select(1);
    }

    public void reload(){
        Scene currentScene = getPane().getScene();
        Platform.runLater(() -> {
            CourseListViewController courseListViewController = new CourseListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
            courseListViewController.setListView();
        });
    }


}
