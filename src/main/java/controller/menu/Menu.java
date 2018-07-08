package controller.menu;

import controller.menu.admin.AdminViewController;
import controller.menu.lesson.CourseListViewController;
import controller.menu.topic.TopicListViewController;
import data.model.Topic;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    private Stage stage;
    private Scene scene;

    @FXML
    private BorderPane borderPane;
    @FXML
    private BorderPane insideBorderPane;

    public void start(Stage stage) throws IOException {
        borderPane = FXMLLoader.load(getClass().getResource("/menu/menu.fxml"));
        scene =  new Scene(borderPane, 800 ,500);scene.getStylesheets().add(getClass().getResource("/menu/ressources/css/courseCustomCell.css").toExternalForm());

        Platform.runLater(() -> {
            stage.setScene(scene);
            stage.show();
            this.stage = stage;
        });
    }

    public void onHomeClick(MouseEvent mouseEvent) {
    }

    public void onLessonsClick(MouseEvent mouseEvent) {
        borderPane.setCenter(insideBorderPane);
        //BottomSideBar bottomSideBar = new BottomSideBar(borderPane);
        TopicListViewController topicListViewController = new TopicListViewController(insideBorderPane);
        ListView<Topic> listView = new ListView<>();
        listView.getStylesheets().add(getClass().getResource("/menu/ressources/css/listViewItem.css").toExternalForm());
        listView.setOnMouseClicked(event -> {
            CourseListViewController courseListViewController = new CourseListViewController(insideBorderPane);
            courseListViewController.setListView(listView.getSelectionModel().getSelectedItem().getId());
        });
        //bottomSideBar.setSideBar();
        topicListViewController.setTopicList(listView);
    }

    public void onQuizzesClick(MouseEvent mouseEvent) {
        borderPane.setCenter(insideBorderPane);
        TopicListViewController topicListViewController = new TopicListViewController(insideBorderPane);
        ListView<Topic> listView = new ListView<>();
        listView.getStylesheets().add(getClass().getResource("/menu/ressources/css/listViewItem.css").toExternalForm());
        listView.setOnMouseClicked(event -> {
        });
        topicListViewController.setTopicList(listView);
    }

    public void onAdminClick(MouseEvent mouseEvent) {
        AdminViewController adminViewController = new AdminViewController(insideBorderPane);
        adminViewController.setListItem();
        borderPane.setBottom(null);
    }

}
