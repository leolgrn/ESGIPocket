package controller.menu.course;

import data.fileuploader.FileUpload;
import data.mainapi.post.ESGIPocketProviderPost;
import data.model.Authentification;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class CourseAddCell  {

    private String idTopic;
    private File fileToUpload;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField filePath;

    @FXML
    private TextField fileName;

    @FXML
    private Button chooseFileButton;

    @FXML
    private Button uploadButton;

    public CourseAddCell(String idTopic){
        this.idTopic = idTopic;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/course/CourseAddCell.fxml"));
        fxmlLoader.setController(this);
        try{
            anchorPane = fxmlLoader.load();
            anchorPane.getStylesheets().add(getClass().getResource("/menu/css/addCell.css").toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public TextField getFileName() {
        return fileName;
    }

    public TextField getFilePath() {
        return filePath;
    }

    public Button getChooseFileButton() {
        return chooseFileButton;
    }

    public Button getUploadButton() {
        return uploadButton;
    }


    public void chooseFile() {

        chooseFileButton.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            Node node = (Node) event.getSource();
            fileToUpload = fileChooser.showOpenDialog(node.getScene().getWindow());

            if (fileToUpload != null) {
                filePath.setText(fileToUpload.getPath());
                fileName.setText(fileToUpload.getName());
            }
            else {
                System.out.println("debug 2");
            }
        });
    }

    public void uploadFile() {
        uploadButton.setOnMouseClicked(event -> {

            String fileFullName = fileToUpload.getName();
            if (!fileFullName.contains(".")) {
                fileFullName = fileFullName + fileToUpload.getName().substring(fileToUpload.getName().lastIndexOf("."), fileToUpload.getName().length());
            }

            FileUpload fileUpload = new FileUpload();
            fileUpload.upload(filePath.getText(), fileName.getText(), fileFullName, idTopic);
        });

    }

    public void setAddCell(){
        chooseFile();
        uploadFile();
    }
}
