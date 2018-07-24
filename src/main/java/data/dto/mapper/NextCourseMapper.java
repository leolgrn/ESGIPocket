package data.dto.mapper;

import data.dto.ENextCourse;
import data.model.NextCourse;
import interfaces.Mapping;

public class NextCourseMapper implements Mapping<NextCourse, ENextCourse> {
    @Override
    public NextCourse map(ENextCourse item) {
        NextCourse nextCourse = new NextCourse();
        nextCourse.setBeginning(item.getBeginning());
        nextCourse.setEnd(item.getEnd());
        nextCourse.setSubject(item.getSubject());
        nextCourse.setTeachers(item.getTeachers());
        return nextCourse;
    }
}
