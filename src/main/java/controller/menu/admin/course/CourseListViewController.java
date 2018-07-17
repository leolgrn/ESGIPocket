package controller.menu.admin.course;

import abstractclass.ListViewController;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Course;
import interfaces.ApiListener;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class CourseListViewController extends ListViewController<Course> {

    public CourseListViewController(BorderPane borderPane) {
        super(borderPane, "center");
    }

    @Override
    public void setListView() {
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getCourses(new ApiListener<ArrayList<Course>>() {
            @Override
            public void onSuccess(ArrayList<Course> response) {
                getObservableList().setAll(response);
                getListView().setItems(getObservableList());
                getListView().setCellFactory(listView -> new CourseCell());
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void setAddCell() {

    }
}
