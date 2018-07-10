package abstractclass;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public abstract class SingleFieldListCell<T> {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text name;

    @FXML
    private Button delete;

    public SingleFieldListCell(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/SingleFieldListCell.fxml"));
        fxmlLoader.setController(this);
        try
        {
            anchorPane = fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
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

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public AnchorPane getPane(){
        return anchorPane;
    }

    public abstract void setInfo(T object);

}
