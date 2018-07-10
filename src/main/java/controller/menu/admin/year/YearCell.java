package controller.menu.admin.year;

import data.model.Year;
import javafx.application.Platform;
import javafx.scene.control.ListCell;

public class YearCell extends ListCell<Year> {
    @Override
    public void updateItem(Year year, boolean empty)
    {
        super.updateItem(year, empty);
        if(year != null){
            YearListCell yearListCell = new YearListCell();
            yearListCell.setInfo(year);
            Platform.runLater(() -> {
                setGraphic(yearListCell.getPane());
            });
        }
    }
}
