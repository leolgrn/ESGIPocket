package controller.menu.admin;

import data.model.Course;
import data.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

public class AdminViewController {

    private BorderPane borderPane;
    private ObservableList<String> observableList;
    private ListView<String> listView;

    public AdminViewController(BorderPane borderPane){
        this.borderPane = borderPane;
    }

    public void setListItem(){
        observableList = FXCollections.observableArrayList("Utilisateurs", "Classes", "Matières", "Cours");
        listView = new ListView<>();
        listView.getStylesheets().add(getClass().getResource("/menu/ressources/css/listViewItem.css").toExternalForm());
        listView.setItems(observableList);
        listView.setOnMouseClicked(event -> {
            loadListView(listView.getSelectionModel().getSelectedItem());
        });
        borderPane.setLeft(listView);
    }

    public void loadListView(String item){
        System.out.print(item);
        switch (item){
            case "Utilisateurs":
                ListView<User> listView = new ListView<>();
                UserListViewController userListViewController = new UserListViewController(listView, borderPane);
                userListViewController.setListView();
                break;
            default:
                System.out.println("Not done yet");
        }
    }


}
