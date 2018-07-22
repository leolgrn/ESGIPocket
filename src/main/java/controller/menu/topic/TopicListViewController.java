package controller.menu.topic;

import abstractclass.ListViewController;
import controller.menu.course.CourseListViewController;
import data.model.Authentification;
import data.model.Topic;
import javafx.scene.layout.BorderPane;

public class TopicListViewController extends ListViewController<Topic> {

    public TopicListViewController(BorderPane borderPane) {
        super(borderPane, "left", "/menu/css/listView.css");
    }

    @Override
    public void setListView() {
        getObservableList().setAll(Authentification.getInstance().getUser().getClasse().getTopic());
        getListView().setItems(getObservableList());
        getListView().setCellFactory(listView -> new TopicCell());
        getListView().setOnMouseClicked(event -> {
            String topicId = getListView().getSelectionModel().getSelectedItem().getId();
            CourseListViewController courseListViewController = new CourseListViewController(topicId, getBorderPane());
            courseListViewController.setListView();
            courseListViewController.setAddCell();
        });
    }

    @Override
    public void setAddCell() {
    }
}
