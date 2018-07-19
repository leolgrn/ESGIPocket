package controller.menu.admin.year;

import abstractclass.SingleFieldListCell;
import abstractclass.TwoFieldListCell;
import data.model.Year;
import data.model.credentials.TwoFieldsCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class YearListCell extends TwoFieldListCell<Year> {
    @Override
    public void setInfo(Year object) {
        getName().setText(object.getName());
        getAcronym().setText(object.getAcronym());
        getDelete().setOnMouseClicked(event -> {
            getEsgiPocketProviderDelete().deleteYear(object.getId(), new ApiListener<String>() {
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
            getEsgiPocketProviderPut().updateYear(twoFieldsCredentials, object.getId(), new ApiListener<Year>() {
                @Override
                public void onSuccess(Year response) {
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
            YearListViewController yearListViewController = new YearListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
            yearListViewController.setListView();
        });
    }
}
