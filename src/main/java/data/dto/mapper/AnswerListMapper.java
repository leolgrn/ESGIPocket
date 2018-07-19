package data.dto.mapper;

import data.dto.EAnswer;
import data.model.Answer;
import interfaces.ArrayListMapping;

import java.util.ArrayList;

public class AnswerListMapper implements ArrayListMapping<Answer, EAnswer> {
    @Override
    public ArrayList<Answer> map(ArrayList<EAnswer> arrayList) {
        ArrayList<Answer> answers = new ArrayList<>();
        for(EAnswer eAnswer: arrayList){
            Answer answer = new Answer();
            QuestionMapper questionMapper = new QuestionMapper();
            answer.setContent(eAnswer.getContent());
            answer.setQuestion(questionMapper.map(eAnswer.geteQuestion()));
            answer.setRightAnswer(eAnswer.getRightAnswer());
            answers.add(answer);
        }
        return answers;
    }
}
