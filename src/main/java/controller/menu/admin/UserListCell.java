package controller.menu.admin;

import data.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class UserListCell {

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
        try
        {
            anchorPane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(User user)
    {
        firstname.setText(user.getFirstname());
        lastname.setText(user.getLastname());
        email.setText(user.getEmail());
        if (user.getActivated()) {
            activated.setText("Activated");
        } else {
            activated.setText("Not Activated");
        }
        delete.setOnMouseClicked(event -> {
            System.out.println(user.getId());
        });
    }

    public AnchorPane getPane(){
        return anchorPane;
    }
}
