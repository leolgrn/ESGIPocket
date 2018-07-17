package controller.menu.admin.user;

import abstractclass.ListViewController;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.User;
import interfaces.ApiListener;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class UserListViewController extends ListViewController<User> {


    public UserListViewController(BorderPane borderPane) {
        super(borderPane, "center");
    }

    @Override
    public void setListView() {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getUsers(new ApiListener<ArrayList<User>>() {
            @Override
            public void onSuccess(ArrayList<User> response) {
                getObservableList().setAll(response);
                getListView().setItems(getObservableList());
                getListView().setCellFactory(listView -> new UserCell());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    @Override
    public void setAddCell() {

    }
}
