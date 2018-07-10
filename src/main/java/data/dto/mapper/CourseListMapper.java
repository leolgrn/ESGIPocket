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
        for(ECourse eCourse: arrayList){
            Course Course = new Course();
            Course.setId(eCourse.getId());
            Course.setArchive(eCourse.getArchive());
            Course.setTitle(eCourse.getTitle());
            Course.setTopic(topicMapper.map(eCourse.getTopic()));
            Course.setClass(classMapper.map(eCourse.getClasse()));
            Course.setCreatedAt(eCourse.getCreatedAt());
            Course.setUpdatedAt(eCourse.getUpdatedAt());
            Course.setContent(eCourse.getContent());
            CourseList.add(Course);
        }
        return CourseList;
    }
}
