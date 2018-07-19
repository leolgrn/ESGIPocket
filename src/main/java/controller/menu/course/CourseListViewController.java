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

    private final String FILE = "course.pdf";
    private final String id;

    public CourseListViewController(String id, BorderPane borderPane) {
        super(borderPane, "center", "/menu/css/courseListView.css");
        this.id = id;
    }

    @Override
    public void setListView() {
        setListCellEvent();
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
        
    }

    public void setListCellEvent(){
        getListView().setOnMouseClicked(event -> {
            if(getListView().getSelectionModel().getSelectedItem().getContent() == null){
                try {
                    URL url = new URL(getListView().getSelectionModel().getSelectedItem().getUrl());
                    readPdf(url);
                    openPdf();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void readPdf(URL url){
        try{
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream fos = new FileOutputStream(new File(FILE));
            byte[] buffer = new byte[512];
            while (true) {
                int length = inputStream.read(buffer);
                if (length == -1) {
                    break;
                }
                fos.write(buffer, 0, length);
            }
            inputStream.close();
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openPdf(){
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
