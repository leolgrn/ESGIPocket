package data.dto.mapper;

import data.dto.EClass;
import data.model.Class;
import interfaces.Mapping;

public class ClassMapper implements Mapping<Class, EClass> {
    @Override
    public Class map(EClass item) {
        Class newClass = new Class();
        SpecialityMapper specialityMapper = new SpecialityMapper();
        GroupMapper groupMapper = new GroupMapper();
        YearMapper yearMapper = new YearMapper();
        newClass.setSpeciality(specialityMapper.map(item.geteSpeciality()));
        newClass.setGroup(groupMapper.map(item.geteGroup()));
        newClass.setYear(yearMapper.map(item.geteYear()));
        return newClass;
    }
}
