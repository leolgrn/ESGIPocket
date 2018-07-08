package controller.menu.lesson;

import interfaces.ApiListener;
import data.mainapi.ESGIPocketProvider;
import data.model.Authentification;
import data.model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class CourseListViewController {

    private final String FILE = "course.pdf";

    private BorderPane insideBorderPane;
    private ObservableList<Course> observableList = FXCollections.observableArrayList();

    @FXML
    private ListView<Course> courseListView;

    public CourseListViewController(BorderPane insideBorderPane) {
        this.insideBorderPane = insideBorderPane;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/listView.fxml"));
        fxmlLoader.setController(this);
        try
        {
            courseListView = fxmlLoader.load();
            courseListView.getStylesheets().add(getClass().getResource("/menu/ressources/css/courseCustomCell.css").toExternalForm());
            this.insideBorderPane.setCenter(courseListView);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setListView(String id) {
        setListCellEvent();
        ESGIPocketProvider esgiPocketProvider = new ESGIPocketProvider(Authentification.getInstance().getToken());
        esgiPocketProvider.getCourses(id, new ApiListener<ArrayList<Course>>() {
            @Override
            public void onSuccess(ArrayList<Course> response) {
                observableList.setAll(response);
                courseListView.setItems(observableList);
                courseListView.setCellFactory((Callback<ListView<Course>, ListCell<Course>>) listView -> new CourseCell());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public void setListCellEvent(){
        courseListView.setOnMouseClicked(event -> {
            URL pdfUrl = null;
            try {
                pdfUrl = new URL(courseListView.getSelectionModel().getSelectedItem().getContent());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            read(pdfUrl);
            open();
        });
    }

    public void read(URL url){
        try{
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
            FileOutputStream fos = new FileOutputStream(new File(FILE));
            byte[] buf = new byte[512];
            while (true) {
                int len = in.read(buf);
                if (len == -1) {
                    break;
                }
                fos.write(buf, 0, len);
            }
            in.close();
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open(){
        try{
            File pdfFile = new File(FILE);
            if (pdfFile.exists()){
                if(Desktop.isDesktopSupported()){
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Awt Desktop is not supported");
                }
            } else{
                System.out.println("File doesn't exists");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
