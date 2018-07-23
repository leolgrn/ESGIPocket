package controller.menu.admin.speciality;

import data.model.Speciality;
import javafx.application.Platform;
import javafx.scene.control.ListCell;

public class SpecialityCell extends ListCell<Speciality> {
    @Override
    public void updateItem(Speciality speciality, boolean empty)
    {
        super.updateItem(speciality, empty);
        if(speciality != null){
            SpecialityListCell specialityListCell = new SpecialityListCell();
            specialityListCell.setInfo(speciality);
            Platform.runLater(() -> {
                setGraphic(specialityListCell.getPane());
            });
        }
    }
}
