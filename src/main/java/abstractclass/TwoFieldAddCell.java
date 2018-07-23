package abstractclass;

import data.mainapi.post.ESGIPocketProviderPost;
import data.model.Authentification;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public abstract class TwoFieldAddCell<T> {

    private ESGIPocketProviderPost esgiPocketProviderPost;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField name;

    @FXML
    private TextField acronym;

    @FXML
    private Button add;

    public TwoFieldAddCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/AddTwoField.fxml"));
        fxmlLoader.setController(this);
        esgiPocketProviderPost = new ESGIPocketProviderPost(Authentification.getInstance().getToken());
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

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public TextField getAcronym() {
        return acronym;
    }

    public void setAcronym(TextField acronym) {
        this.acronym = acronym;
    }

    public Button getAdd() {
        return add;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    public ESGIPocketProviderPost getEsgiPocketProviderPost() {
        return esgiPocketProviderPost;
    }

    public void setEsgiPocketProviderPost(ESGIPocketProviderPost esgiPocketProviderPost) {
        this.esgiPocketProviderPost = esgiPocketProviderPost;
    }

    public abstract void setAddCell();
}
