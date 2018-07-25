package controller.menu.course;

import data.model.Course;

import java.util.Comparator;

public class VoteComparator implements Comparator<Course> {
    @Override
    public int compare(Course o1, Course o2) {
        if(o2.getLike() == o1.getLike()){
            return o1.getDislike() - o2.getDislike();
        } else {
            return o2.getLike() - o1.getLike();
        }
    }
}
