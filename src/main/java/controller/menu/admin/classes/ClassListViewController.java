package controller.menu.admin.classes;

import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Class;
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

public class ClassListViewController {

    private BorderPane borderPane;

    private ObservableList<Class> observableList = FXCollections.observableArrayList();
    private ListView<Class> listView;

    public ClassListViewController(ListView<Class> listView, BorderPane borderPane) {
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
        esgiPocketProvider.getClasses(new ApiListener<ArrayList<Class>>() {
            @Override
            public void onSuccess(ArrayList<Class> response) {
                observableList.setAll(response);
                listView.setItems(observableList);
                listView.setCellFactory((Callback<ListView<Class>, ListCell<Class>>) listView -> new ClassCell());
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
