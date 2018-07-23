package controller.menu.admin.year;

import abstractclass.TwoFieldAddCell;
import data.model.Year;
import data.model.credentials.TwoFieldsCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class YearAddCell extends TwoFieldAddCell<Year> {
    @Override
    public void setAddCell() {
        getName().setPromptText("Nom");
        getAcronym().setPromptText("Acronyme");
        getAdd().setOnMouseClicked(event -> {
            TwoFieldsCredentials twoFieldsCredentials = new TwoFieldsCredentials(getName().getText(), getAcronym().getText());
            getEsgiPocketProviderPost().postYear(twoFieldsCredentials, new ApiListener<Year>() {
                @Override
                public void onSuccess(Year response) {
                    getName().setText("");
                    getAcronym().setText("");
                    Scene currentScene = getAnchorPane().getScene();
                    Platform.runLater(() -> {
                        YearListViewController yearListViewController = new YearListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
                        yearListViewController.setListView();
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
