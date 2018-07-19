package controller.menu.admin.classes;

import data.mainapi.delete.ESGIPocketProviderDelete;
import data.mainapi.put.ESGIPocketProviderPut;
import data.model.Authentification;
import data.model.Class;
import data.model.Topic;
import data.model.Year;
import data.model.credentials.ClassCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class ClassListCell extends abstractclass.ClassListCell {

    private ESGIPocketProviderDelete esgiPocketProviderDelete;

    private ESGIPocketProviderPut esgiPocketProviderPut;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    public ClassListCell(){
        super("/menu/admin/ClassListCell.fxml", false);
        esgiPocketProviderDelete = new ESGIPocketProviderDelete(Authentification.getInstance().getToken());
        esgiPocketProviderPut = new ESGIPocketProviderPut(Authentification.getInstance().getToken());
    }

    @Override
    public void setCell(Class newClass) {
        getAnchorPane().setId("class-list-cell");
        setYear(true, newClass);
        setGroup(true, newClass);
        setSpeciality(true, newClass);
        setTopics(true, newClass);
        delete.setOnMouseClicked(event -> {
            esgiPocketProviderDelete.deleteClass(newClass.getId(), new ApiListener<String>() {
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
            String year = getYear().getSelectionModel().getSelectedItem().getId();
            String group = getGroup().getSelectionModel().getSelectedItem().getId();
            String speciality = getSpeciality().getSelectionModel().getSelectedItem().getId();
            ObservableList<Topic> topics = getTopics().getCheckModel().getCheckedItems();
            String[] topicsArray = new String[topics.size()];
            for(int i = 0; i < topics.size(); i++){
                topicsArray[i] = topics.get(i).getId();
            }
            ClassCredentials classCredentials = new ClassCredentials(year, group, speciality, topicsArray);
            esgiPocketProviderPut.updateClass(classCredentials, newClass.getId(), new ApiListener<Class>() {
                @Override
                public void onSuccess(Class response) {
                    reload();
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    @Override
    public void reload() {
        Scene currentScene = getAnchorPane().getScene();
        Platform.runLater(() -> {
            ClassListViewController classListViewController = new ClassListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
            classListViewController.setListView();
        });
    }
}