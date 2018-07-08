package data.dto.mapper;

import data.dto.EYear;
import data.model.Year;
import interfaces.Mapping;

public class YearMapper implements Mapping<Year, EYear> {
    @Override
    public Year map(EYear item) {
        Year year = new Year();
        year.setAcronym(item.getAcronym());
        year.setName(item.getName());
        return year;
    }
}
