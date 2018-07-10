package controller.menu.admin.speciality;

import abstractclass.ListViewController;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Speciality;
import interfaces.ApiListener;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class SpecialityListViewController extends ListViewController<Speciality> {
    public SpecialityListViewController(BorderPane borderPane) {
        super(borderPane, "center");
    }

    @Override
    public void setListView() {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getSpecialities(new ApiListener<ArrayList<Speciality>>() {
            @Override
            public void onSuccess(ArrayList<Speciality> response) {
                getObservableList().setAll(response);
                getListView().setItems(getObservableList());
                getListView().setCellFactory(listView -> new SpecialityCell());
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
