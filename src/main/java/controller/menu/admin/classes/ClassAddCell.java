package controller.menu.admin.classes;

import abstractclass.ClassListCell;
import data.mainapi.ESGIPocketProvider;
import data.mainapi.post.ESGIPocketProviderPost;
import data.model.*;
import data.model.Class;
import data.model.credentials.ClassCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.util.ArrayList;

public class ClassAddCell extends ClassListCell {

    private ESGIPocketProviderPost esgiPocketProviderPost;

    @FXML
    private Button add;

    public ClassAddCell() {
        super("/menu/admin/ClassAddCell.fxml", true);
        esgiPocketProviderPost = new ESGIPocketProviderPost(Authentification.getInstance().getToken());
    }

    @Override
    public void setCell(Class newClass){
        setYear(false, newClass);
        setGroup(false, newClass);
        setSpeciality(false, newClass);
        setTopics(false, newClass);
        add.setOnMouseClicked(event -> {
            String year = getYear().getSelectionModel().getSelectedItem().getId();
            String group = getGroup().getSelectionModel().getSelectedItem().getId();
            String speciality = getSpeciality().getSelectionModel().getSelectedItem().getId();
            ObservableList<Topic> topics = getTopics().getCheckModel().getCheckedItems();
            String[] topicsArray = new String[topics.size()];
            for(int i = 0; i < topics.size(); i++){
                topicsArray[i] = topics.get(i).getId();
            }
            ClassCredentials classCredentials = new ClassCredentials(year, group, speciality, topicsArray);
            esgiPocketProviderPost.postClass(classCredentials, new ApiListener<Class>() {
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
            classListViewController.setAddCell();
        });
    }


}
