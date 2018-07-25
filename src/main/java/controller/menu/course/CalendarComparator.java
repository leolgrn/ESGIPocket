package controller.menu.course;

import data.model.Course;

import java.util.Comparator;

public class CalendarComparator implements Comparator<Course> {
    @Override
    public int compare(Course o1, Course o2) {
        if(o1.getCreatedAt().getYear() != o2.getCreatedAt().getYear()){
            return o2.getCreatedAt().getYear() - o1.getCreatedAt().getYear();
        } else {
            if(o1.getCreatedAt().getMonth() != o2.getCreatedAt().getMonth()){
                return o2.getCreatedAt().getMonth() - o1.getCreatedAt().getMonth();
            } else {
                if(o1.getCreatedAt().getDay() != o2.getCreatedAt().getDay()){
                    return o2.getCreatedAt().getDay() - o1.getCreatedAt().getDay();
                } else {
                    if(o1.getCreatedAt().getHour() != o2.getCreatedAt().getHour()){
                        return o2.getCreatedAt().getHour() - o1.getCreatedAt().getHour();
                    } else {
                        if(o1.getCreatedAt().getMin() != o2.getCreatedAt().getMin()){
                            return o2.getCreatedAt().getMin() - o1.getCreatedAt().getMin();
                        } else {
                            return o2.getCreatedAt().getSec() - o1.getCreatedAt().getSec();
                        }
                    }
                }
            }
        }
    }
}
