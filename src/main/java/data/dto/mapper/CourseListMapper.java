package data.dto.mapper;

import data.dto.ECourse;
import data.model.Course;
import interfaces.ArrayListMapping;

import java.util.ArrayList;

public class CourseListMapper implements ArrayListMapping<Course, ECourse> {

    @Override
    public ArrayList<Course> map(ArrayList<ECourse> arrayList) {
        ArrayList<Course> CourseList = new ArrayList<>();
        ClassMapper classMapper = new ClassMapper();
        TopicMapper topicMapper = new TopicMapper();
        CalendarMapper calendarMapper = new CalendarMapper();
        for(ECourse eCourse: arrayList){
            Course course = new Course();
            UserMapper userMapper = new UserMapper();
            course.setId(eCourse.getId());
            course.setArchive(eCourse.getArchive());
            course.setTitle(eCourse.getTitle());
            course.setTopic(topicMapper.map(eCourse.getTopic()));
            if(eCourse.getClasse() != null){
                course.setClass(classMapper.map(eCourse.getClasse()));
            }
            course.setCreatedAt(calendarMapper.map(eCourse.getCreatedAt()));
            course.setUpdatedAt(calendarMapper.map(eCourse.getUpdatedAt()));
            course.setContent(eCourse.getContent());
            course.setUser(userMapper.map(eCourse.getUser()));
            course.setLike(eCourse.getLike());
            course.setDislike(eCourse.getDislike());
            course.setUrl(eCourse.getUrl());
            CourseList.add(course);
        }
        return CourseList;
    }
}
