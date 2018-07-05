package controller.menu.lesson;

import interfaces.ApiListener;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

public class CourseListViewController {

    @FXML
    private ListView<Course> courseListView;

    private BorderPane insideBorderPane;

    ObservableList<Course> observableList = FXCollections.observableArrayList();

    public CourseListViewController(BorderPane insideBorderPane) {
        this.insideBorderPane = insideBorderPane;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/listView.fxml"));
        fxmlLoader.setController(this);
        try
        {
            courseListView = fxmlLoader.load();
            courseListView.setOnMouseClicked(event -> {
                System.out.println(courseListView.getSelectionModel().getSelectedItem().getContent());
            });
            this.insideBorderPane.setCenter(courseListView);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public ListView getCourseListView() {
        return courseListView;
    }

    public void setListView(String id) {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getCourses(id, new ApiListener<ArrayList<Course>>() {
            @Override
            public void onSuccess(ArrayList<Course> response) {
                System.out.println(response.toString());
                observableList.setAll(response);
                courseListView.setItems(observableList);
                courseListView.setCellFactory((Callback<ListView<Course>, ListCell<Course>>) listView -> new CourseCell());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }


}
