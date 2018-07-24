package data.dto.mapper;

import data.dto.EQuiz;
import data.model.Quiz;
import interfaces.Mapping;

public class QuizzMapper implements Mapping<Quiz,EQuiz> {
    @Override
    public Quiz map(EQuiz item) {
        Quiz quiz = new Quiz();
        TopicMapper topicMapper = new TopicMapper();
        UserMapper userMapper = new UserMapper();
        quiz.setId(item.getId());
        quiz.setName(item.getName());
        quiz.setTopic(topicMapper.map(item.geteTopic()));
        quiz.setUser(userMapper.map(item.geteUser()));
        return quiz;
    }
}
