package controller.menu;

import controller.menu.admin.AdminViewController;
import controller.menu.home.HomeController;
import controller.menu.quizzes.QuizCreationController;
import controller.menu.course.topic.TopicListViewController;
import data.model.Authentification;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import settings.MainSettings;

import java.io.IOException;

public class Menu {

    private Scene scene;

    @FXML
    private BorderPane borderPane;

    @FXML
    private BorderPane insideBorderPane;

    @FXML
    private Button admin;

    @FXML
    private Button quiz;

    @FXML
    private Button course;

    @FXML
    private Button home;

    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/menu.fxml"));
        fxmlLoader.setController(this);
        try{
            borderPane = fxmlLoader.load();
            borderPane.getStylesheets().add(getClass().getResource("/menu/css/menu.css").toExternalForm());
            scene = new Scene(borderPane, MainSettings.WIDTH, MainSettings.HEIGHT);
            if(Authentification.getInstance().getUser().getRole() != MainSettings.ADMIN) {
                admin.setVisible(false);
            }
            new HomeController(insideBorderPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> {
            stage.setScene(scene);
            stage.show();
        });
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public BorderPane getInsideBorderPane() {
        return insideBorderPane;
    }

    public void setInsideBorderPane(BorderPane insideBorderPane) {
        this.insideBorderPane = insideBorderPane;
    }

    public void onHomeClick(MouseEvent mouseEvent) {
        new HomeController(insideBorderPane);
        borderPane.setBottom(null);
        insideBorderPane.setLeft(null);
        insideBorderPane.setBottom(null);
    }

    public void onLessonsClick(MouseEvent mouseEvent) {
        TopicListViewController topicListViewController = new TopicListViewController(insideBorderPane);
        topicListViewController.setListView();
        borderPane.setBottom(null);
        insideBorderPane.setCenter(null);
    }

    public void onQuizzesClick(MouseEvent mouseEvent) {
        QuizCreationController quizCreationController = new QuizCreationController(insideBorderPane);
        borderPane.setBottom(null);
        insideBorderPane.setLeft(null);
        insideBorderPane.setBottom(null);
    }

    public void onAdminClick(MouseEvent mouseEvent) {
        AdminViewController adminViewController = new AdminViewController(insideBorderPane);
        adminViewController.setListView();
        borderPane.setBottom(null);
        insideBorderPane.setCenter(null);
    }

}
