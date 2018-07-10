package controller.menu.admin.year;

import abstractclass.SingleFieldListCell;
import data.model.Year;

public class YearListCell extends SingleFieldListCell<Year> {
    @Override
    public void setInfo(Year object) {
        super.getName().setText(object.getName());
    }
}
