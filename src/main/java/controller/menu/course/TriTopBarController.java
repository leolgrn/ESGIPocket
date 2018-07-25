package controller.menu.course;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TriTopBarController {

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private AnchorPane anchorPane;

    public TriTopBarController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/course/TriTopBar.fxml"));
        fxmlLoader.setController(this);
        try
        {
            anchorPane = fxmlLoader.load();
            anchorPane.getStylesheets().add(getClass().getResource("/menu/css/addCell.css").toExternalForm());
            setChoiceBox();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public ChoiceBox<String> getChoiceBox() {
        return choiceBox;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    private void setChoiceBox() {
        ObservableList<String> observableList = FXCollections.observableArrayList("mieux notés", "plus récents");
        choiceBox.setItems(observableList);
    }

}
