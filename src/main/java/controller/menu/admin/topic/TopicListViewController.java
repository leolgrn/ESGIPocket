package controller.menu.admin.topic;

import abstractclass.ListViewController;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Topic;
import interfaces.ApiListener;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class TopicListViewController extends ListViewController<Topic> {

    public TopicListViewController(BorderPane borderPane) {
        super(borderPane, "center");
    }

    @Override
    public void setListView() {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getTopics(new ApiListener<ArrayList<Topic>>() {
            @Override
            public void onSuccess(ArrayList<Topic> response) {
                getObservableList().setAll(response);
                getListView().setItems(getObservableList());
                getListView().setCellFactory(listView -> new TopicCell());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
