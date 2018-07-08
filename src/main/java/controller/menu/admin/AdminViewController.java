package controller.menu.admin;

import controller.menu.admin.classes.ClassListViewController;
import controller.menu.admin.user.UserListViewController;
import data.model.User;
import data.model.Class;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

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
                ListView<User> userListView = new ListView<>();
                UserListViewController userListViewController = new UserListViewController(userListView, borderPane);
                userListViewController.setListView();
                break;
            case "Classes":
                ListView<Class> classListView = new ListView<>();
                ClassListViewController classListViewController = new ClassListViewController(classListView, borderPane);
                classListViewController.setListView();
                break;
            default:
                System.out.println("Not done yet");
        }
    }


}
