package controller.menu;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    private Stage stage;
    private Scene scene;
    @FXML
    private BorderPane borderPane;
    private Parent root;

    public void start(Stage stage) throws IOException {
        borderPane = FXMLLoader.load(getClass().getResource("/menu/menu.fxml"));
        scene =  new Scene(borderPane, 800 ,500);

        Platform.runLater(() -> {
            stage.setScene(scene);
            stage.show();
            this.stage = stage;
        });
    }


    public void onHomeClick(MouseEvent mouseEvent) {
    }

    public void onLessonsClick(MouseEvent mouseEvent) {
        loadFXML("/menu/lessons.fxml");

    }

    public void onQuizzesClick(MouseEvent mouseEvent) {
        loadFXML("/menu/quizzes.fxml");


    }

    public void onAdminClick(MouseEvent mouseEvent) {
        loadFXML("/menu/admin.fxml");
    }

    public void loadFXML(String window){
        try {
            root = FXMLLoader.load(getClass().getResource(window));

        } catch (IOException e) {
            e.printStackTrace();
        }

        Platform.runLater(() -> {
            borderPane.setCenter(root);
        });


    }
}
