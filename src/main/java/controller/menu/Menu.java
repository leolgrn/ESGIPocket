package controller.menu;

import controller.menu.lesson.CourseListViewController;
import interfaces.ApiListener;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Topic;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Menu {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private BorderPane borderPane;
    @FXML
    private BorderPane insideBorderPane;

    private ListView<Topic> listView;

    public void start(Stage stage) throws IOException {
        borderPane = FXMLLoader.load(getClass().getResource("/menu/menu.fxml"));
        scene =  new Scene(borderPane, 800 ,500);
        scene.getStylesheets().add(getClass().getResource("/menu/ressources/css/stylesheet.css").toExternalForm());

        Platform.runLater(() -> {
            stage.setScene(scene);
            stage.show();
            this.stage = stage;
        });
    }

    public void onHomeClick(MouseEvent mouseEvent) {
    }

    public void onLessonsClick(MouseEvent mouseEvent) {
        listView = new ListView<>();
        setTopicList(Authentification.getInstance().getToken());
        listView.setOnMouseClicked(event -> {
            CourseListViewController courseListViewController = new CourseListViewController(insideBorderPane);
            courseListViewController.setListView(listView.getSelectionModel().getSelectedItem().getId());
        });
    }

    public void onQuizzesClick(MouseEvent mouseEvent) {
        listView = new ListView<>();
        setTopicList(Authentification.getInstance().getToken());
        listView.setOnMouseClicked(event -> {
            CourseListViewController courseListViewController = new CourseListViewController(insideBorderPane);
            courseListViewController.setListView(listView.getSelectionModel().getSelectedItem().getId());
        });
    }

    public void onAdminClick(MouseEvent mouseEvent) {
        loadFXML("/menu/admin.fxml");
    }


    private void setTopicList(String token) {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(token);
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
                    insideBorderPane.setLeft(listView);
                });
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }



    public void loadFXML(String window){
        try {
            root = FXMLLoader.load(getClass().getResource(window));

        } catch (IOException e) {
            e.printStackTrace();
        }

        Platform.runLater(() -> {
            //borderPane.getChildren()
        });


    }
}
