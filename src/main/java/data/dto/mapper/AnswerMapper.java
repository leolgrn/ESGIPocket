package data.dto.mapper;

import data.dto.EAnswer;
import data.model.Answer;
import interfaces.Mapping;

public class AnswerMapper implements Mapping<Answer, EAnswer> {
    @Override
    public Answer map(EAnswer item) {
        Answer answer = new Answer();
        QuestionMapper questionMapper = new QuestionMapper();
        answer.setContent(item.getContent());
        answer.setQuestion(questionMapper.map(item.geteQuestion()));
        answer.setRightAnswer(item.getRightAnswer());
        return answer;
    }
}
