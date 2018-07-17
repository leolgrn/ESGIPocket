package controller.menu.admin.classes;

import data.mainapi.delete.ESGIPocketProviderDelete;
import data.model.Authentification;
import data.model.Class;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class ClassListCell {

    private ESGIPocketProviderDelete esgiPocketProviderDelete;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text speciality;

    @FXML
    private Text group;

    @FXML
    private Text year;

    @FXML
    private Button delete;

    public ClassListCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/ClassListCell.fxml"));
        fxmlLoader.setController(this);
        esgiPocketProviderDelete = new ESGIPocketProviderDelete(Authentification.getInstance().getToken());
        try
        {
            anchorPane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(Class newClass) {
        speciality.setText(newClass.getSpeciality().getName());
        group.setText(newClass.getGroup().getName());
        year.setText(newClass.getYear().getName());
        delete.setOnMouseClicked(event -> {
            esgiPocketProviderDelete.deleteClass(newClass.getId(), new ApiListener<String>() {
                @Override
                public void onSuccess(String response) {
                    Scene currentScene = getPane().getScene();
                    Platform.runLater(() -> {
                        ClassListViewController classListViewController = new ClassListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
                        classListViewController.setListView();
                    });
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    public AnchorPane getPane(){
        return anchorPane;
    }
}