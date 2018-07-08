package controller.menu.admin.user;

import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.User;
import interfaces.ApiListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

public class UserListViewController {

    private BorderPane borderPane;

    private ObservableList<User> observableList = FXCollections.observableArrayList();
    private ListView<User> listView;

    public UserListViewController(ListView<User> listView, BorderPane borderPane) {
        this.borderPane = borderPane;
        this.listView = listView;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/listView.fxml"));
        fxmlLoader.setController(this);
        try
        {
            this.listView = fxmlLoader.load();
            this.listView.getStylesheets().add(getClass().getResource("/menu/ressources/css/courseCustomCell.css").toExternalForm());
            this.borderPane.setCenter(this.listView);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setListView() {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getUsers(new ApiListener<ArrayList<User>>() {
            @Override
            public void onSuccess(ArrayList<User> response) {
                observableList.setAll(response);
                listView.setItems(observableList);
                listView.setCellFactory((Callback<ListView<User>, ListCell<User>>) listView -> new UserCell());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
