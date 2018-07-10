package controller.menu.admin.speciality;

import abstractclass.SingleFieldListCell;
import data.model.Speciality;

public class SpecialityListCell extends SingleFieldListCell<Speciality> {
    @Override
    public void setInfo(Speciality object) {
        getName().setText(object.getName());
    }
}
