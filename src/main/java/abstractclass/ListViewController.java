package abstractclass;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public abstract class ListViewController<T> {

    private BorderPane borderPane;
    private ListView<T> listView;
    private ObservableList<T> observableList;

    public ListViewController(BorderPane borderPane, String placement, String css) {
        this.borderPane = borderPane;
        this.observableList = FXCollections.observableArrayList();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/listView.fxml"));
        fxmlLoader.setController(this);
        try
        {
            this.listView = fxmlLoader.load();
            this.listView.getStylesheets().add(getClass().getResource(css).toExternalForm());
            setListViewInBorderPane(placement);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public ListViewController(BorderPane borderPane, String placement) {
        this.borderPane = borderPane;
        this.observableList = FXCollections.observableArrayList();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/listView.fxml"));
        fxmlLoader.setController(this);
        try
        {
            this.listView = fxmlLoader.load();
            this.listView.getStylesheets().add(getClass().getResource("/menu/css/listView.css").toExternalForm());
            setListViewInBorderPane(placement);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public void setListView(ListView<T> listView) {
        this.listView = listView;
    }

    public ObservableList<T> getObservableList() {
        return observableList;
    }

    public void setObservableList(ObservableList<T> observableList) {
        this.observableList = observableList;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public ListView<T> getListView() {
        return listView;
    }

    public void setListViewInBorderPane(String placement){
        if (placement.equals("center")) {
            this.borderPane.setCenter(this.listView);
        } else if (placement.equals("left")){
            this.borderPane.setLeft(this.listView);
        }
    }

    public abstract void setListView();

    public abstract void setAddCell();


}
