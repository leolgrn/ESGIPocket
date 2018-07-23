package abstractclass;

import data.mainapi.ESGIPocketProvider;
import data.model.*;
import data.model.Class;
import interfaces.ApiListener;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.util.ArrayList;

public abstract class ClassListCell {

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

    public ClassListCell(String fxml, Boolean css){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        fxmlLoader.setController(this);
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

    public abstract void reload();

    public abstract void setCell(Class newClass);

    public void setYear(Boolean select, Class newClass){
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
                if (select) {
                    Platform.runLater(() -> {
                        int index = 0;
                        for(int i = 0; i < year.getItems().size(); i++){
                            if(year.getItems().get(i).equals(newClass.getYear())){
                                index = i;
                            }
                        }
                        year.getSelectionModel().select(index);
                    });
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public void setGroup(Boolean select, Class newClass){
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
                if(select) {
                    Platform.runLater(() -> {
                        int index = 0;
                        for(int i = 0; i < group.getItems().size(); i++){
                            if(group.getItems().get(i).equals(newClass.getGroup())){
                                index = i;
                            }
                        }
                        group.getSelectionModel().select(index);
                    });
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public void setSpeciality(Boolean select, Class newClass){
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
                if (select){
                    Platform.runLater(() -> {
                        int index = 0;
                        for(int i = 0; i < speciality.getItems().size(); i++){
                            if(speciality.getItems().get(i).equals(newClass.getSpeciality())){
                                index = i;
                            }
                        }
                        speciality.getSelectionModel().select(index);
                    });
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public void setTopics(Boolean select, Class newClass){
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
                if(select){
                    for (Topic topic: newClass.getTopic()){
                        Platform.runLater(() -> {
                            int index = 0;
                            for(int i = 0; i < topics.getItems().size(); i++){
                                if(topics.getItems().get(i).equals(topic)){
                                    topics.getCheckModel().check(i);
                                }
                            }
                        });
                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
