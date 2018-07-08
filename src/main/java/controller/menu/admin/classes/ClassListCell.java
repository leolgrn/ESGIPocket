package controller.menu.admin.classes;

import data.model.Class;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class ClassListCell {

        @FXML
        private AnchorPane anchorPane;

        @FXML
        private Text speciality;

        @FXML
        private Text group;

        @FXML
        private Text year;

        @FXML
        private Button delete;

        public ClassListCell(){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/menu/admin/ClassListCell.fxml"));
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

        public void setInfo(Class newClass)
        {
            speciality.setText(newClass.getSpeciality().getName());
            group.setText(newClass.getGroup().getName());
            year.setText(newClass.getYear().getName());
        }

        public AnchorPane getPane(){
            return anchorPane;
        }
}


