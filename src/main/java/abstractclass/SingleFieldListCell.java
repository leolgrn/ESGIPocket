package abstractclass;

import data.mainapi.delete.ESGIPocketProviderDelete;
import data.model.Authentification;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public abstract class SingleFieldListCell<T> {

    private ESGIPocketProviderDelete esgiPocketProviderDelete;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text name;

    @FXML
    private Button delete;

    public SingleFieldListCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/SingleFieldListCell.fxml"));
        fxmlLoader.setController(this);
        esgiPocketProviderDelete = new ESGIPocketProviderDelete(Authentification.getInstance().getToken());
        try
        {
            anchorPane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public AnchorPane getPane() {
        return anchorPane;
    }

    public Text getName() {
        return name;
    }

    public void setName(Text name) {
        this.name = name;
    }

    public Button getDelete() {
        return delete;
    }

    public ESGIPocketProviderDelete getEsgiPocketProviderDelete() {
        return esgiPocketProviderDelete;
    }

    public abstract void setInfo(T object);


}
