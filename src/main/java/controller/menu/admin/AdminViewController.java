package controller.menu.admin;

import abstractclass.ListViewController;
import controller.menu.admin.classes.ClassListViewController;
import controller.menu.admin.course.CourseListViewController;
import controller.menu.admin.group.GroupListViewController;
import controller.menu.admin.speciality.SpecialityListViewController;
import controller.menu.admin.topic.TopicListViewController;
import controller.menu.admin.user.UserListViewController;
import controller.menu.admin.year.YearListViewController;
import javafx.scene.layout.BorderPane;

public class AdminViewController extends ListViewController<String> {

    public AdminViewController(BorderPane borderPane){
        super(borderPane, "left");
    }

    @Override
    public void setListView() {
        getObservableList().setAll("Utilisateurs", "Classes", "Matières", "Cours", "Groupes", "Années", "Spécialités");
        getListView().setItems(getObservableList());
        getListView().setOnMouseClicked(event -> {
            loadListView(getListView().getSelectionModel().getSelectedItem());
        });
    }

    public void loadListView(String item){
        switch (item){
            case "Utilisateurs":
                UserListViewController userListViewController = new UserListViewController(getBorderPane());
                userListViewController.setListView();
                break;
            case "Classes":
                ClassListViewController classListViewController = new ClassListViewController(getBorderPane());
                classListViewController.setListView();
                break;
            case "Matières":
                TopicListViewController topicListViewController = new TopicListViewController(getBorderPane());
                topicListViewController.setListView();
                break;
            case "Cours":
                CourseListViewController courseListViewController = new CourseListViewController(getBorderPane());
                courseListViewController.setListView();
                break;
            case "Groupes":
                GroupListViewController groupListViewController = new GroupListViewController(getBorderPane());
                groupListViewController.setListView();
                break;
            case "Spécialités":
                SpecialityListViewController specialityListViewController = new SpecialityListViewController(getBorderPane());
                specialityListViewController.setListView();
                break;
            case "Années":
                YearListViewController yearListViewController = new YearListViewController(getBorderPane());
                yearListViewController.setListView();
                break;
            default:
                System.out.println("No model");
        }
    }

}
