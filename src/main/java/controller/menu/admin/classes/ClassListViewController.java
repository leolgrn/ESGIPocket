package controller.menu.admin.classes;

import abstractclass.ListViewController;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Class;
import interfaces.ApiListener;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class ClassListViewController extends ListViewController<Class> {

    public ClassListViewController(BorderPane borderPane) {
        super(borderPane, "center");
    }

    @Override
    public void setListView() {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getClasses(new ApiListener<ArrayList<Class>>() {
            @Override
            public void onSuccess(ArrayList<Class> response) {
                getObservableList().setAll(response);
                getListView().setItems(getObservableList());
                getListView().setCellFactory(listView -> new ClassCell());
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}