package controller.menu.admin.group;

import abstractclass.SingleFieldListCell;
import abstractclass.TwoFieldListCell;
import data.model.Group;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class GroupListCell extends TwoFieldListCell<Group> {
    @Override
    public void setInfo(Group object) {
        getName().setText(object.getName());
        getAcronym().setText(object.getNumber());
        getDelete().setOnMouseClicked(event -> {
            getEsgiPocketProviderDelete().deleteGroup(object.getId(), new ApiListener<String>() {
                @Override
                public void onSuccess(String response) {
                    Scene currentScene = getPane().getScene();
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
        getUpdate().setOnMouseClicked(event -> {
            getE
        });
    }
}
