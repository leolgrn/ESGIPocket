package controller.menu;

import controller.menu.admin.AdminViewController;
import controller.menu.topic.TopicListViewController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import settings.MainSettings;

import java.io.IOException;

public class Menu {

    @FXML
    private BorderPane borderPane;
    @FXML
    private BorderPane insideBorderPane;

    public void start(Stage stage) throws IOException {
        borderPane = FXMLLoader.load(getClass().getResource("/menu/menu.fxml"));
        Scene scene =  new Scene(borderPane, MainSettings.WIDTH, MainSettings.HEIGHT);
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
        borderPane.setBottom(null);
        insideBorderPane.setLeft(null);
        insideBorderPane.setCenter(null);
    }

    public void onLessonsClick(MouseEvent mouseEvent) {
        TopicListViewController topicListViewController = new TopicListViewController(insideBorderPane);
        topicListViewController.setListView();
        borderPane.setBottom(null);
        insideBorderPane.setCenter(null);
    }

    public void onQuizzesClick(MouseEvent mouseEvent) {
        borderPane.setBottom(null);
        insideBorderPane.setLeft(null);
        insideBorderPane.setCenter(null);
    }

    public void onAdminClick(MouseEvent mouseEvent) {
        AdminViewController adminViewController = new AdminViewController(insideBorderPane);
        adminViewController.setListView();
        borderPane.setBottom(null);
        insideBorderPane.setCenter(null);
    }

}
