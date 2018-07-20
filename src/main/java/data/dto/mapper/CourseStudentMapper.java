package data.dto.mapper;

import data.dto.ECourseStudent;
import data.model.CourseStudent;
import interfaces.Mapping;

public class CourseStudentMapper implements Mapping<CourseStudent, ECourseStudent> {

    @Override
    public CourseStudent map(ECourseStudent item) {
        CourseStudent courseStudent = new CourseStudent();
        CourseMapper courseMapper = new CourseMapper();
        UserMapper userMapper = new UserMapper();
        if(item.getAuthor() != null){
            courseStudent.setAuthor(item.getAuthor());
        }
        courseStudent.setCourse(courseMapper.map(item.geteCourse()));
        courseStudent.setFavorite(item.getFavorite());
        courseStudent.setId(item.getId());
        courseStudent.setUser(userMapper.map(item.geteUser()));
        courseStudent.setVote(item.getVote());
        return courseStudent;
    }
}
