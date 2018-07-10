package data.dto.mapper;

import data.dto.EYear;
import data.model.Year;
import interfaces.ArrayListMapping;

import java.util.ArrayList;

public class YearListMapper implements ArrayListMapping<Year, EYear> {
    @Override
    public ArrayList<Year> map(ArrayList<EYear> arrayList) {
        ArrayList<Year> yearArrayList = new ArrayList<>();
        for(EYear eYear: arrayList){
            Year year = new Year();
            year.setAcronym(eYear.getAcronym());
            year.setName(eYear.getName());
            yearArrayList.add(year);
        }
        return yearArrayList;
    }
}
