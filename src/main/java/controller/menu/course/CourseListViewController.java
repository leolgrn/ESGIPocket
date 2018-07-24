package controller.menu.course;

import abstractclass.ListViewController;
import interfaces.ApiListener;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Course;
import javafx.scene.layout.BorderPane;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class CourseListViewController extends ListViewController<Course> {

    private final String id;

    public CourseListViewController(String id, BorderPane borderPane) {
        super(borderPane, "center", "/menu/css/courseListView.css");
        this.id = id;
    }

    @Override
    public void setListView() {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getCoursesById(id, new ApiListener<ArrayList<Course>>() {
            @Override
            public void onSuccess(ArrayList<Course> response) {
                getObservableList().setAll(response);
                getListView().setItems(getObservableList());
                getListView().setCellFactory(listView -> new CourseCell());
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
}
