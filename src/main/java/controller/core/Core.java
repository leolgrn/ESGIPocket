package controller.core;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import settings.MainSettings;

public class Core extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("ESGIPocket");
        Parent root = FXMLLoader.load(getClass().getResource("/core/authentification.fxml"));
        Scene scene = new Scene(root, MainSettings.WIDTH, MainSettings.HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
