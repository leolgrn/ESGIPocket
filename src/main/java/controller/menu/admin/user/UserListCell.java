package controller.menu.admin.user;

import data.mainapi.delete.ESGIPocketProviderDelete;
import data.model.Authentification;
import data.model.User;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class UserListCell {

    private ESGIPocketProviderDelete esgiPocketProviderDelete;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text firstname;

    @FXML
    private Text lastname;

    @FXML
    private Text email;

    @FXML
    private Text activated;

    @FXML
    private Button delete;

    public UserListCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/UserListCell.fxml"));
        fxmlLoader.setController(this);
        esgiPocketProviderDelete = new ESGIPocketProviderDelete(Authentification.getInstance().getToken());
        try
        {
            anchorPane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(User user) {
        firstname.setText(user.getFirstname());
        lastname.setText(user.getLastname());
        email.setText(user.getEmail());
        if (user.getActivated()) {
            activated.setText("Activated");
        } else {
            activated.setText("Not Activated");
        }
        delete.setOnMouseClicked(event -> {
            esgiPocketProviderDelete.deleteUser(user.getId(), new ApiListener<String>() {
                @Override
                public void onSuccess(String response) {
                    Scene currentScene = getPane().getScene();
                    Platform.runLater(() -> {
                        UserListViewController userListViewController = new UserListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
                        userListViewController.setListView();
                    });
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    public AnchorPane getPane(){
        return anchorPane;
    }
}
