package data.dto.mapper;

import data.dto.ECourseStudent;
import data.model.CourseStudent;
import interfaces.ArrayListMapping;

import java.util.ArrayList;

public class CourseStudentListMapper implements ArrayListMapping<CourseStudent, ECourseStudent> {

    @Override
    public ArrayList<CourseStudent> map(ArrayList<ECourseStudent> arrayList) {
        ArrayList<CourseStudent> courseStudentArrayList = new ArrayList<>();
        for(ECourseStudent eCourseStudent: arrayList){
            CourseStudent courseStudent = new CourseStudent();
            CourseMapper courseMapper = new CourseMapper();
            UserMapper userMapper = new UserMapper();
            if(eCourseStudent.getAuthor() != null){
                courseStudent.setAuthor(eCourseStudent.getAuthor());
            }
            courseStudent.setCourse(courseMapper.map(eCourseStudent.geteCourse()));
            courseStudent.setFavorite(eCourseStudent.getFavorite());
            courseStudent.setId(eCourseStudent.getId());
            courseStudent.setUser(userMapper.map(eCourseStudent.geteUser()));
            courseStudent.setVote(eCourseStudent.getVote());
            courseStudentArrayList.add(courseStudent);
        }
        return courseStudentArrayList;
    }
}
