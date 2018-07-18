package controller.menu.admin.classes;

import data.mainapi.ESGIPocketProvider;
import data.mainapi.post.ESGIPocketProviderPost;
import data.model.*;
import data.model.Class;
import data.model.credentials.ClassCredentials;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.util.ArrayList;

public class ClassAddCell {

    private ESGIPocketProviderPost esgiPocketProviderPost;

    private ESGIPocketProvider esgiPocketProvider;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ChoiceBox<Year> year;

    @FXML
    private ChoiceBox<Group> group;

    @FXML
    private ChoiceBox<Speciality> speciality;

    @FXML
    private CheckComboBox<Topic> topics;

    @FXML
    private Button add;

    public ClassAddCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/ClassAddCell.fxml"));
        fxmlLoader.setController(this);
        esgiPocketProviderPost = new ESGIPocketProviderPost(Authentification.getInstance().getToken());
        esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        try{
            anchorPane = fxmlLoader.load();
            anchorPane.getStylesheets().add(getClass().getResource("/menu/css/addCell.css").toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public ChoiceBox<Year> getYear() {
        return year;
    }

    public void setYear(ChoiceBox<Year> year) {
        this.year = year;
    }

    public ChoiceBox<Group> getGroup() {
        return group;
    }

    public void setGroup(ChoiceBox<Group> group) {
        this.group = group;
    }

    public ChoiceBox<Speciality> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(ChoiceBox<Speciality> speciality) {
        this.speciality = speciality;
    }

    public CheckComboBox<Topic> getTopics() {
        return topics;
    }

    public void setTopics(CheckComboBox<Topic> topics) {
        this.topics = topics;
    }

    public void setAddCell(){
        setYear();
        setGroup();
        setSpeciality();
        setTopics();
        add.setOnMouseClicked(event -> {
            String year = this.year.getSelectionModel().getSelectedItem().getId();
            String group = this.group.getSelectionModel().getSelectedItem().getId();
            String speciality = this.speciality.getSelectionModel().getSelectedItem().getId();
            ObservableList<Topic> topics = this.topics.getCheckModel().getCheckedItems();
            String[] topicsArray = new String[topics.size()];
            for(int i = 0; i < topics.size(); i++){
                topicsArray[i] = topics.get(i).getId();
            }
            ClassCredentials classCredentials = new ClassCredentials(year, group, speciality, topicsArray);
            esgiPocketProviderPost.postClass(classCredentials, new ApiListener<Class>() {
                @Override
                public void onSuccess(Class response) {
                    Scene currentScene = getAnchorPane().getScene();
                    Platform.runLater(() -> {
                        ClassListViewController classListViewController = new ClassListViewController((BorderPane) currentScene.lookup("#insideBorderPane"));
                        classListViewController.setListView();
                        classListViewController.setAddCell();
                    });
                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        });
    }

    public void setYear(){
        esgiPocketProvider.getYears(new ApiListener<ArrayList<Year>>() {
            @Override
            public void onSuccess(ArrayList<Year> response) {
                ObservableList<Year> observableList = FXCollections.observableArrayList(response);
                year.setItems(observableList);
                year.setConverter(new StringConverter<Year>() {
                    @Override
                    public String toString(Year object) {
                        return object.getName();
                    }

                    @Override
                    public Year fromString(String string) {
                        return null;
                    }
                });
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public void setGroup(){
        esgiPocketProvider.getGroups(new ApiListener<ArrayList<Group>>() {
            @Override
            public void onSuccess(ArrayList<Group> response) {
                ObservableList<Group> observableList = FXCollections.observableArrayList(response);
                group.setItems(observableList);
                group.setConverter(new StringConverter<Group>() {
                    @Override
                    public String toString(Group object) {
                        return object.getName();
                    }

                    @Override
                    public Group fromString(String string) {
                        return null;
                    }
                });
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public void setSpeciality(){
        esgiPocketProvider.getSpecialities(new ApiListener<ArrayList<Speciality>>() {
            @Override
            public void onSuccess(ArrayList<Speciality> response) {
                ObservableList<Speciality> observableList = FXCollections.observableArrayList(response);
                speciality.setItems(observableList);
                speciality.setConverter(new StringConverter<Speciality>() {
                    @Override
                    public String toString(Speciality object) {
                        return object.getName();
                    }

                    @Override
                    public Speciality fromString(String string) {
                        return null;
                    }
                });
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public void setTopics(){
        esgiPocketProvider.getTopics(new ApiListener<ArrayList<Topic>>() {
            @Override
            public void onSuccess(ArrayList<Topic> response) {
                ObservableList<Topic> observableList = FXCollections.observableArrayList(response);
                topics.getItems().addAll(observableList);
                topics.setConverter(new StringConverter<Topic>() {
                    @Override
                    public String toString(Topic object) {
                        return object.getName();
                    }

                    @Override
                    public Topic fromString(String string) {
                        return null;
                    }
                });
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
