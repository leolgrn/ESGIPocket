package data.dto.mapper;

import data.dto.EQuestion;
import data.model.Question;
import interfaces.Mapping;

public class QuestionMapper implements Mapping<Question, EQuestion> {
    @Override
    public Question map(EQuestion item) {
        Question question = new Question();
        QuizzMapper quizzMapper = new QuizzMapper();
        question.setContent(item.getContent());
        question.setId(item.getId());
        question.setQuiz(quizzMapper.map(item.geteQuiz()));
        return question;
    }
}
