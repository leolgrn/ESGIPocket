package data.dto.mapper;

import data.dto.ECourse;
import data.model.Course;
import interfaces.Mapping;

public class CourseMapper implements Mapping<Course, ECourse> {

    @Override
    public Course map(ECourse item) {
        Course course = new Course();
        UserMapper userMapper = new UserMapper();
        TopicMapper topicMapper = new TopicMapper();
        ClassMapper classMapper = new ClassMapper();
        course.setId(item.getId());
        course.setArchive(item.getArchive());
        course.setTitle(item.getTitle());
        course.setTopic(topicMapper.map(item.getTopic()));
        if(item.getClasse() != null){
            course.setClass(classMapper.map(item.getClasse()));
        }
        course.setCreatedAt(item.getCreatedAt());
        course.setUpdatedAt(item.getUpdatedAt());
        course.setContent(item.getContent());
        course.setUser(userMapper.map(item.getUser()));
        course.setLike(item.getLike());
        course.setDislike(item.getDislike());
        course.setUrl(item.getUrl());
        return course;
    }
}
