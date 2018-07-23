package controller.core.auth;

import controller.menu.Menu;
import interfaces.ApiListener;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.credentials.LoginCredentials;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import settings.MainSettings;

import java.io.IOException;

public class authController {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    public void onSignInButtonClick(MouseEvent mouseEvent) {
        LoginCredentials loginCredentials = new LoginCredentials(email.getText(), password.getText());
        //LoginCredentials loginCredentials = new LoginCredentials(MainSettings.mail, MainSettings.password);
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider();
        esgiPocketProvider.postLogIn(loginCredentials, new ApiListener<Authentification>() {
            public void onSuccess(Authentification response) {
                System.out.println(response.toString());
                Menu menu = new Menu();
                Stage currentStage = (Stage) email.getScene().getWindow();
                menu.start(currentStage);
            }

            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }

}
