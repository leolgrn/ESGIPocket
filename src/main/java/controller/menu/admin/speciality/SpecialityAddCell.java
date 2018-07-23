package controller.menu.admin.speciality;

import abstractclass.TwoFieldAddCell;
import data.model.Speciality;
import data.model.credentials.TwoFieldsCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class SpecialityAddCell extends TwoFieldAddCell<Speciality> {

    @Override
    public void setAddCell() {
        getName().setPromptText("Nom");
        getAcronym().setPromptText("Acronyme");
        getAdd().setOnMouseClicked(event -> {
            TwoFieldsCredentials twoFieldsCredentials = new TwoFieldsCredentials(getName().getText(), getAcronym().getText());
            getEsgiPocketProviderPost().postSpeciality(twoFieldsCredentials, new ApiListener<Speciality>() {

                @Override
                public void onSuccess(Speciality response) {
                    getName().setText("");
                    getAcronym().setText("");
                    Scene currentScene = getAnchorPane().getScene();
                    Platform.runLater(() -> {
                        SpecialityListViewController specialityListViewController = new SpecialityListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
                        specialityListViewController.setListView();
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
