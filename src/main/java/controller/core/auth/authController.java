package controller.core.auth;

import controller.menu.Menu;
import interfaces.ApiListener;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.credentials.LoginCredentials;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.SocketTimeoutException;

public class authController {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Label error;

    public authController() {
        Platform.runLater(() -> {
            error.setVisible(false);
        });
    }

    public void onSignInButtonClick(MouseEvent mouseEvent) {
        LoginCredentials loginCredentials = new LoginCredentials(email.getText(), password.getText());
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider();
        esgiPocketProvider.postLogIn(loginCredentials, new ApiListener<Authentification>() {
            public void onSuccess(Authentification response) {
                if(response != null){
                    error.setVisible(false);
                    Menu menu = new Menu();
                    Stage currentStage = (Stage) email.getScene().getWindow();
                    menu.start(currentStage);
                } else {
                    error.setVisible(true);
                    email.setText("");
                    password.setText("");
                }
            }

            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

}
