package abstractclass;

import data.mainapi.ESGIPocketProvider;
import data.mainapi.delete.ESGIPocketProviderDelete;
import data.mainapi.put.ESGIPocketProviderPut;
import data.model.Authentification;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public abstract class SingleFieldListCell<T> {

    private ESGIPocketProviderDelete esgiPocketProviderDelete;

    private ESGIPocketProviderPut esgiPocketProviderPut;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField name;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    public SingleFieldListCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/SingleFieldListCell.fxml"));
        fxmlLoader.setController(this);
        esgiPocketProviderDelete = new ESGIPocketProviderDelete(Authentification.getInstance().getToken());
        esgiPocketProviderPut = new ESGIPocketProviderPut(Authentification.getInstance().getToken());
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

    public Button getDelete() {
        return delete;
    }

    public ESGIPocketProviderDelete getEsgiPocketProviderDelete() {
        return esgiPocketProviderDelete;
    }

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public Button getUpdate() {
        return update;
    }

    public ESGIPocketProviderPut getEsgiPocketProviderPut() {
        return esgiPocketProviderPut;
    }

    public abstract void setInfo(T object);

    public abstract void reload();

}
