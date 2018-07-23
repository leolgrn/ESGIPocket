package controller.menu.admin.user;

import data.mainapi.delete.ESGIPocketProviderDelete;
import data.mainapi.put.ESGIPocketProviderPut;
import data.model.Authentification;
import data.model.User;
import data.model.credentials.UserCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import settings.MainSettings;

import java.io.IOException;

public class UserListCell {

    private ESGIPocketProviderDelete esgiPocketProviderDelete;

    private ESGIPocketProviderPut esgiPocketProviderPut;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField email;

    @FXML
    private ChoiceBox<String> activated;

    @FXML
    private ChoiceBox<String> status;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    public UserListCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/UserListCell.fxml"));
        fxmlLoader.setController(this);
        esgiPocketProviderDelete = new ESGIPocketProviderDelete(Authentification.getInstance().getToken());
        esgiPocketProviderPut = new ESGIPocketProviderPut(Authentification.getInstance().getToken());
        try
        {
            anchorPane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public TextField getFirstname() {
        return firstname;
    }

    public void setFirstname(TextField firstname) {
        this.firstname = firstname;
    }

    public TextField getLastname() {
        return lastname;
    }

    public void setLastname(TextField lastname) {
        this.lastname = lastname;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public ChoiceBox<String> getActivated() {
        return activated;
    }

    public void setActivated(ChoiceBox<String> activated) {
        this.activated = activated;
    }

    public ChoiceBox<String> getStatus() {
        return status;
    }

    public void setStatus(ChoiceBox<String> status) {
        this.status = status;
    }

    public AnchorPane getPane(){
        return anchorPane;
    }

    public void setInfo(User user) {
        firstname.setText(user.getFirstname());
        lastname.setText(user.getLastname());
        email.setText(user.getEmail());
        setStatus(user);
        setActivated(user);
        setUpdate(user);
        setDelete(user);
    }

    public void setStatus(User user){
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.setAll("Admin", "Étudiant", "Professeur");
        status.setItems(observableList);
        if(user.getRole() == MainSettings.ADMIN){
            status.getSelectionModel().select(0);
        } else if(user.getRole() == MainSettings.STUDENT){
            status.getSelectionModel().select(1);
        } else {
            status.getSelectionModel().select(2);
        }
    }

    public void setActivated(User user){
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.setAll("Activé", "Desactivé");
        activated.setItems(observableList);
        if(user.getActivated()){
            activated.getSelectionModel().select(0);
        } else {
            activated.getSelectionModel().select(1);
        }
    }

    public void setDelete(User user){
        delete.setOnMouseClicked(event -> {
            esgiPocketProviderDelete.deleteUser(user.getId(), new ApiListener<String>() {
                @Override
                public void onSuccess(String response) {
                    reloadScene();
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    public void setUpdate(User user){
        update.setOnMouseClicked(event -> {
            String firstname = getFirstname().getText();
            String lastname = getLastname().getText();
            String email = getEmail().getText();
            int status = MainSettings.STUDENT;
            switch (getStatus().getValue()){
                case "Admin":
                    status = MainSettings.ADMIN;
                break;
                case "Étudiant":
                    status = MainSettings.STUDENT;
                    break;
                case "Professeur":
                    status = MainSettings.TEACHER;
                break;
                default:
                    System.out.println("Wrong status");
                break;
            }
            Boolean activated;
            if (getActivated().getValue().equals("Activé")) activated = true;
            else activated = false;
            UserCredentials userCredentials = new UserCredentials(firstname, lastname, email, activated, status);
            esgiPocketProviderPut.updateUser(userCredentials, user.getId(), new ApiListener<User>() {
                @Override
                public void onSuccess(User response) {
                    System.out.println(response.toString());
                    reloadScene();
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    public void reloadScene(){
        Scene currentScene = getPane().getScene();
        Platform.runLater(() -> {
            UserListViewController userListViewController = new UserListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
            userListViewController.setListView();
        });
    }
}
