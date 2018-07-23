package data.dto.mapper;

import data.dto.EQuiz;
import data.model.Quiz;
import interfaces.ArrayListMapping;

import java.util.ArrayList;

public class QuizListMapper implements ArrayListMapping<Quiz, EQuiz> {
    @Override
    public ArrayList<Quiz> map(ArrayList<EQuiz> arrayList) {
        ArrayList<Quiz> quizArrayList = new ArrayList<>();
        for(EQuiz eQuiz: arrayList){
            Quiz quiz = new Quiz();
            TopicMapper topicMapper = new TopicMapper();
            quiz.setId(eQuiz.getId());
            quiz.setName(eQuiz.getName());
            quiz.setTopic(topicMapper.map(eQuiz.geteTopic()));
            quizArrayList.add(quiz);
        }
        return quizArrayList;
    }
}
