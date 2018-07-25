package data.dto.mapper;

import data.dto.ECourse;
import data.model.Calendar;
import data.model.Course;
import interfaces.Mapping;

public class CalendarMapper implements Mapping<Calendar, String> {
    @Override
    public Calendar map(String item) {
        Calendar calendar = new Calendar();
        calendar.setYear(Integer.parseInt(item.substring(0, 4)));
        calendar.setMonth(Integer.parseInt(item.substring(5, 7)));
        calendar.setDay(Integer.parseInt(item.substring(8, 10)));
        calendar.setHour(Integer.parseInt(item.substring(11, 13)));
        calendar.setMin(Integer.parseInt(item.substring(14, 16)));
        calendar.setSec(Integer.parseInt(item.substring(17, 19)));
        return calendar;
    }
}
