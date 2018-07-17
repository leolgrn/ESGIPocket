package controller.menu.admin.classes;

import data.mainapi.ESGIPocketProvider;
import data.mainapi.post.ESGIPocketProviderPost;
import data.model.*;
import data.model.credentials.ClassCredentials;
import interfaces.ApiListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;

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
    private ComboBox<Topic> topics;

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

    public void setAddCell(){
        setYear();
        setGroup();
        setSpeciality();
        setTopics();
        add.setOnMouseClicked(event -> {
            String year = this.year.getSelectionModel().getSelectedItem().getId();
            String group = this.group.getSelectionModel().getSelectedItem().getId();
            String speciality = this.speciality.getSelectionModel().getSelectedItem().getId();
            System.out.println(year);
            System.out.println(group);
            System.out.println(speciality);
            //ClassCredentials classCredentials = new ClassCredentials(year, group, speciality);
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
                topics.setItems(observableList);
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
