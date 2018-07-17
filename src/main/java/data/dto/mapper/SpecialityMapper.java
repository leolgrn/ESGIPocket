package data.dto.mapper;

import data.dto.ESpeciality;
import data.model.Speciality;
import interfaces.Mapping;

public class SpecialityMapper implements Mapping<Speciality, ESpeciality> {
    @Override
    public Speciality map(ESpeciality item) {
        Speciality speciality = new Speciality();
        speciality.setAcronym(item.getAcronym());
        speciality.setName(item.getName());
        speciality.setId(item.getId());
        return speciality;
    }
}
