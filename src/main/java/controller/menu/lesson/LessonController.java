package controller.menu.lesson;

import data.mainapi.ApiListener;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Topic;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.util.ArrayList;

public class LessonController {

    @FXML
    AnchorPane lessonAnchorPane;

    @FXML
    ListView lessonListView;

    private ArrayList<Topic> topicArrayList;

    public LessonController(){
        getTopicArrayList(Authentification.getInstance().getToken());
    }

    public ArrayList<Topic> getTopicArrayList() {
        return topicArrayList;
    }

    public void setTopicArrayList(ArrayList<Topic> topicArrayList) {
        this.topicArrayList = topicArrayList;
    }

    private void getTopicArrayList(String token) {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(token);
        esgiPocketProvider.getTopics(new ApiListener<ArrayList<Topic>>() {
            @Override
            public void onSuccess(ArrayList<Topic> response) {
                setTopicArrayList(response);
                createListView();
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    private void createListView(){
        ObservableList<Topic> observableList = FXCollections.observableList(getTopicArrayList());
        System.out.println(getTopicArrayList().toString());
        lessonListView.setItems(observableList);
        lessonListView.setCellFactory(new Callback<ListView<Topic>, ListCell<Topic>>(){

            @Override
            public ListCell<Topic> call(ListView<Topic> p) {

                ListCell<Topic> cell = new ListCell<Topic>(){

                    @Override
                    protected void updateItem(Topic topic, boolean bln) {
                        super.updateItem(topic, bln);
                        if (topic != null) {
                            setText(topic.getName());
                        }
                    }

                };

                return cell;
            }
        });

    }

}
