package controller.menu.admin.group;

import abstractclass.ListViewController;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Group;
import interfaces.ApiListener;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class GroupListViewController extends ListViewController<Group> {

    public GroupListViewController(BorderPane borderPane) {
        super(borderPane, "center");
    }

    @Override
    public void setListView() {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getGroups(new ApiListener<ArrayList<Group>>() {
            @Override
            public void onSuccess(ArrayList<Group> response) {
                getObservableList().setAll(response);
                getListView().setItems(getObservableList());
                getListView().setCellFactory(listView -> new GroupCell());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    @Override
    public void setAddCell() {
        GroupAddCell groupAddCell = new GroupAddCell();
        groupAddCell.setAddCell();
        getBorderPane().setBottom(groupAddCell.getAnchorPane());
    }
}
