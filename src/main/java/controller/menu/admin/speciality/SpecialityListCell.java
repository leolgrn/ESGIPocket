package controller.menu.admin.speciality;

import abstractclass.SingleFieldListCell;
import data.model.Speciality;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class SpecialityListCell extends SingleFieldListCell<Speciality> {
    @Override
    public void setInfo(Speciality object) {
        getName().setText(object.getName());
        getDelete().setOnMouseClicked(event -> {
            getEsgiPocketProviderDelete().deleteSpeciality(object.getId(), new ApiListener<String>() {
                @Override
                public void onSuccess(String response) {
                    Scene currentScene = getPane().getScene();
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
