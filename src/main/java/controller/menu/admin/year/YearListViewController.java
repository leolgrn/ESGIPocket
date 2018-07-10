package controller.menu.admin.year;

import abstractclass.ListViewController;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Year;
import interfaces.ApiListener;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class YearListViewController extends ListViewController<Year> {

    public YearListViewController(BorderPane borderPane) {
        super(borderPane, "center");
    }

    @Override
    public void setListView() {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getYears(new ApiListener<ArrayList<Year>>() {
            @Override
            public void onSuccess(ArrayList<Year> response) {
                getObservableList().setAll(response);
                getListView().setItems(getObservableList());
                getListView().setCellFactory(listView -> new YearCell());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

}
