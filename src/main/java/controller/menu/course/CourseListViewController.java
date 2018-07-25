package controller.menu.course;

import abstractclass.ListViewController;
import interfaces.ApiListener;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Course;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class CourseListViewController extends ListViewController<Course> {

    private final String id;
    private BorderPane borderPane;
    private ArrayList<Course> courseArrayList;

    public CourseListViewController(String id, BorderPane borderPane) {
        super(borderPane, "center", "/menu/css/courseListView.css");
        this.id = id;
        this.borderPane = borderPane;
        setTri();
    }

    @Override
    public void setListView() {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getCoursesById(id, new ApiListener<ArrayList<Course>>() {
            @Override
            public void onSuccess(ArrayList<Course> response) {
                courseArrayList = response;
                setCourseListView(null);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    @Override
    public void setAddCell() {
        CourseAddCell courseAddCell = new CourseAddCell(id);
        courseAddCell.setAddCell();
        getBorderPane().setBottom(courseAddCell.getAnchorPane());
    }

    public void setCourseListView(Comparator<Course> comparator){
        if(comparator != null){
            Collections.sort(courseArrayList, comparator);
        }
        getObservableList().setAll(courseArrayList);
        getListView().setItems(getObservableList());
        getListView().setCellFactory(listView -> new CourseCell());
    }

    public void setTri(){
        TriTopBarController triTopBarController = new TriTopBarController();
        borderPane.setTop(triTopBarController.getAnchorPane());
        triTopBarController.getChoiceBox().setOnAction(event -> {
            reloadCourses(triTopBarController.getChoiceBox().getSelectionModel().getSelectedItem());
        });
    }

    private void reloadCourses(String tri){
        switch (tri){
            case "mieux notés":
                setCourseListView(new VoteComparator());
                break;
            case "plus récents":
                setCourseListView(new CalendarComparator());
                break;
        }
    }
}
