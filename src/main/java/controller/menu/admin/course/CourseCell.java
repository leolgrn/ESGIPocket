package controller.menu.admin.course;

import data.model.Course;
import javafx.application.Platform;
import javafx.scene.control.ListCell;

public class CourseCell extends ListCell<Course> {
    @Override
    public void updateItem(Course course, boolean empty)
    {
        super.updateItem(course, empty);
        if(course != null){
            CourseListCell courseListCell = new CourseListCell();
            courseListCell.setInfo(course);
            Platform.runLater(() -> {
                setGraphic(courseListCell.getPane());
            });
        }
    }
}
