package abstractclass;

import data.model.Course;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public abstract class ListViewController {

    private BorderPane borderPane;

    private ListView<?> listView;

    public ListViewController(ListView<?> listView, BorderPane borderPane) {
        this.borderPane = borderPane;
        this.listView = listView;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/listView.fxml"));
        fxmlLoader.setController(this);
        try
        {
            this.listView = fxmlLoader.load();
            this.listView.getStylesheets().add(getClass().getResource("/menu/ressources/css/courseCustomCell.css").toExternalForm());
            this.borderPane.setCenter(this.listView);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public ListView<?> getListView() {
        return listView;
    }

    public abstract void setListView();
}
