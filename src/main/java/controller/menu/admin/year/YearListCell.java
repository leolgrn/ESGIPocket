package controller.menu.admin.year;

import abstractclass.SingleFieldListCell;
import data.model.Year;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class YearListCell extends SingleFieldListCell<Year> {
    @Override
    public void setInfo(Year object) {
        getName().setText(object.getName());
        getDelete().setOnMouseClicked(event -> {
            getEsgiPocketProviderDelete().deleteYear(object.getId(), new ApiListener<String>() {
                @Override
                public void onSuccess(String response) {
                    Scene currentScene = getPane().getScene();
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
