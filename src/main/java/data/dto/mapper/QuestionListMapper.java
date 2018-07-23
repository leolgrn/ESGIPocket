package data.dto.mapper;

import data.dto.EQuestion;
import data.model.Question;
import interfaces.ArrayListMapping;

import java.util.ArrayList;

public class QuestionListMapper implements ArrayListMapping<Question, EQuestion> {
    @Override
    public ArrayList<Question> map(ArrayList<EQuestion> arrayList) {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        for(EQuestion eQuestion: arrayList){
            Question question = new Question();
            QuizzMapper quizzMapper = new QuizzMapper();
            question.setContent(eQuestion.getContent());
            question.setId(eQuestion.getId());
            question.setQuiz(quizzMapper.map(eQuestion.geteQuiz()));
            questionArrayList.add(question);
        }
        return questionArrayList;
    }
}
