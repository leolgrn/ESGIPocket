package controller.menu.course;

import data.mainapi.ESGIPocketProvider;
import data.mainapi.post.ESGIPocketProviderPost;
import data.model.Authentification;
import data.model.Course;
import data.model.CourseStudent;
import data.model.credentials.CourseStudentCredentials;
import interfaces.ApiListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import settings.MainSettings;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CourseListCell {

    private ESGIPocketProvider esgiPocketProvider;

    private ESGIPocketProviderPost esgiPocketProviderPost;

    private int vote;

    @FXML
    public AnchorPane anchorPane;
    @FXML
    public Text lessonTitle;
    @FXML
    public Text lessonTopic;
    @FXML
    public Text lessonAuthor;
    @FXML
    public Text like;
    @FXML
    public Text dislike;
    @FXML
    public Button green;
    @FXML
    public Button red;
    @FXML
    public ImageView green_thumb;
    @FXML
    public ImageView red_thumb;
    @FXML
    public Text description;
    @FXML
    public Button dowload;
    @FXML
    public Text date;

    public CourseListCell() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/course/courseCustomCell.fxml"));
        fxmlLoader.setController(this);
        String token = Authentification.getInstance().getToken();
        esgiPocketProvider = new ESGIPocketProvider(token);
        esgiPocketProviderPost = new ESGIPocketProviderPost(token);
        vote = MainSettings.notvotedYet;
        try
        {
            anchorPane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public AnchorPane getPane(){
        return anchorPane;
    }

    public void setInfo(Course course)
    {
        lessonTitle.setText(course.getTitle());
        lessonTopic.setText(course.getTopic().getName());
        lessonAuthor.setText(course.getUser().getFirstname() + " " + course.getUser().getLastname());
        like.setText(Integer.toString(course.getLike()));
        dislike.setText(Integer.toString(course.getDislike()));
        date.setText("Créé le : " + getCreationDate(course));
        setVote(course);
        setGreenVote(course);
        setRedVote(course);
        setDowload(course);
    }

    public String getCreationDate(Course course){
        String day = course.getCreatedAt().getDay() < 10 ? "0" + Integer.toString(course.getCreatedAt().getDay()) : Integer.toString(course.getCreatedAt().getDay());
        String month = course.getCreatedAt().getMonth() < 10 ? "0" + Integer.toString(course.getCreatedAt().getMonth()) : Integer.toString(course.getCreatedAt().getMonth());
        return day + "/" + month + "/" + Integer.toString(course.getCreatedAt().getYear());
    }

    public void setVote(Course course){
        esgiPocketProvider.getCourseStudentByCourseId(course.getId(), new ApiListener<CourseStudent>() {
            @Override
            public void onSuccess(CourseStudent response) {
                if(response != null){
                    if(response.getVote()){
                        vote = MainSettings.greenVote;
                        Image image = new Image("/menu/course/ressources/full_green.png");
                        green_thumb.setImage(image);
                    } else {
                        vote = MainSettings.redVote;
                        Image image = new Image("/menu/course/ressources/full_red.png");
                        red_thumb.setImage(image);
                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    public void setGreenVote(Course course){
        green.setOnMouseClicked(event -> {
            if(vote != MainSettings.greenVote){
                CourseStudentCredentials courseStudentCredentials = new CourseStudentCredentials(course.getId(), true);
                esgiPocketProviderPost.postCourseStudent(courseStudentCredentials, new ApiListener<CourseStudent>() {
                    @Override
                    public void onSuccess(CourseStudent response) {
                        if(vote == MainSettings.redVote){
                            dislike.setText(Integer.toString(Integer.parseInt(dislike.getText()) - 1));
                            like.setText(Integer.toString(Integer.parseInt(like.getText()) + 1));
                        } else if(vote == MainSettings.notvotedYet){
                            like.setText(Integer.toString(Integer.parseInt(like.getText()) + 1));
                        }
                        vote = MainSettings.greenVote;
                        Image greenImage = new Image("/menu/course/ressources/full_green.png");
                        green_thumb.setImage(greenImage);
                        Image redImage = new Image("/menu/course/ressources/red.png");
                        red_thumb.setImage(redImage);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
            }
        });
    }

    public void setRedVote(Course course){
        red.setOnMouseClicked(event -> {
            if(vote != MainSettings.redVote){
                CourseStudentCredentials courseStudentCredentials = new CourseStudentCredentials(course.getId(), false);
                esgiPocketProviderPost.postCourseStudent(courseStudentCredentials, new ApiListener<CourseStudent>() {
                    @Override
                    public void onSuccess(CourseStudent response) {
                        if(vote == MainSettings.greenVote){
                            dislike.setText(Integer.toString(Integer.parseInt(dislike.getText()) + 1));
                            like.setText(Integer.toString(Integer.parseInt(like.getText()) - 1));
                        } else if(vote == MainSettings.notvotedYet){
                            dislike.setText(Integer.toString(Integer.parseInt(dislike.getText()) + 1));
                        }
                        vote = MainSettings.redVote;
                        Image redImage = new Image("/menu/course/ressources/full_red.png");
                        red_thumb.setImage(redImage);
                        Image greenImage = new Image("/menu/course/ressources/green.png");
                        green_thumb.setImage(greenImage);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
            }
        });
    }

    public void setDowload(Course course){
        dowload.setOnMouseClicked(event -> {
            if(course.getContent() == null){
                String extension = course.getUrl().substring(course.getUrl().lastIndexOf("."), course.getUrl().length());
                try {
                    URL url = new URL(course.getUrl());
                    readPdf(url, extension);
                    openPdf(extension);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void readPdf(URL url, String extension){
        try{
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream fos = new FileOutputStream(new File(MainSettings.FILE + extension));
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

    public void openPdf(String extension){
        try{
            File pdfFile = new File(MainSettings.FILE + extension);
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
