package data.dto.mapper;

import data.dto.ESpeciality;
import data.model.Speciality;
import interfaces.ArrayListMapping;

import java.util.ArrayList;

public class SpecialityListMapper implements ArrayListMapping<Speciality, ESpeciality> {
    @Override
    public ArrayList<Speciality> map(ArrayList<ESpeciality> arrayList) {
        ArrayList<Speciality> specialityArrayList = new ArrayList<>();
        for(ESpeciality eSpeciality: arrayList){
            Speciality speciality = new Speciality();
            speciality.setAcronym(eSpeciality.getAcronym());
            speciality.setName(eSpeciality.getName());
            specialityArrayList.add(speciality);
        }
        return specialityArrayList;
    }
}
