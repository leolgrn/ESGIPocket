package controller.menu.course.bottomSideBar;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class BottomSideBarController {

    private BorderPane borderPane;

    @FXML
    private Button addCourseButton;

    @FXML
    private AnchorPane anchorPane;

    public BottomSideBarController(BorderPane borderPane) {
        this.borderPane = borderPane;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/course/bottom_sidebar.fxml"));
        fxmlLoader.setController(this);
        try {
            anchorPane = fxmlLoader.load();
            anchorPane.getStylesheets().add(getClass().getResource("/menu/css/bottomSideBar.css").toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSideBar(){
        borderPane.setBottom(anchorPane);
        addCourseButton.setOnMouseClicked(event -> {

        });
    }


}
