package controller.menu.admin.group;

import abstractclass.TwoFieldAddCell;
import data.model.Group;
import data.model.Speciality;
import data.model.credentials.TwoFieldsCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class GroupAddCell extends TwoFieldAddCell<Group> {
    @Override
    public void setAddCell() {
        getName().setPromptText("Nom");
        getAcronym().setPromptText("Nombre");
        getAdd().setOnMouseClicked(event -> {
            TwoFieldsCredentials twoFieldsCredentials = new TwoFieldsCredentials(getName().getText(), getAcronym().getText());
            getEsgiPocketProviderPost().postGroup(twoFieldsCredentials, new ApiListener<Group>() {

                @Override
                public void onSuccess(Group response) {
                    getName().setText("");
                    getAcronym().setText("");
                    Scene currentScene = getAnchorPane().getScene();
                    Platform.runLater(() -> {
                        GroupListViewController groupListViewController = new GroupListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
                        groupListViewController.setListView();
                    });
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }
}
