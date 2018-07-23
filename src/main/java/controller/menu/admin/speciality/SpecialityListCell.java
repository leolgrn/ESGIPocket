package controller.menu.admin.speciality;

import abstractclass.SingleFieldListCell;
import abstractclass.TwoFieldListCell;
import data.model.Speciality;
import data.model.credentials.TwoFieldsCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class SpecialityListCell extends TwoFieldListCell<Speciality> {
    @Override
    public void setInfo(Speciality object) {
        getName().setText(object.getName());
        getAcronym().setText(object.getAcronym());
        getDelete().setOnMouseClicked(event -> {
            getEsgiPocketProviderDelete().deleteSpeciality(object.getId(), new ApiListener<String>() {
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
        getUpdate().setOnMouseClicked(event -> {
            String name = getName().getText();
            String acronym = getAcronym().getText();
            TwoFieldsCredentials twoFieldsCredentials = new TwoFieldsCredentials(name, acronym);
            getEsgiPocketProviderPut().updateSpeciality(twoFieldsCredentials, object.getId(), new ApiListener<Speciality>() {
                @Override
                public void onSuccess(Speciality response) {
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
        Scene currentScene = getPane().getScene();
        Platform.runLater(() -> {
            SpecialityListViewController specialityListViewController = new SpecialityListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
            specialityListViewController.setListView();
        });
    }
}
