package controller.menu.topic;

import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Topic;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class TopicListViewController {

    private BorderPane borderPane;

    public TopicListViewController(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public void setTopicList(ListView<Topic> listView) {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getTopics(new ApiListener<ArrayList<Topic>>() {
            @Override
            public void onSuccess(ArrayList<Topic> response) {
                System.out.println(response.toString());
                ObservableList<Topic> items = FXCollections.observableArrayList(response);
                Platform.runLater(() -> {
                    listView.setItems(items);
                    listView.setCellFactory(param -> new ListCell<Topic>() {
                        @Override
                        protected void updateItem(Topic item, boolean empty) {
                            super.updateItem(item, empty);

                            if (empty || item == null || item.getName() == null) {
                                setText(null);
                            } else {
                                setText(item.getName());
                            }
                        }
                    });
                    borderPane.setLeft(listView);
                });
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
