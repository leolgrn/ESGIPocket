package data.model.credentials;

import java.util.ArrayList;

public class QuestionAndAnswerCredentials {

    private String question;
    private ArrayList<AnswerCredentials> answers;

    public QuestionAndAnswerCredentials(String question, ArrayList<AnswerCredentials> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<AnswerCredentials> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "QuestionAndAnswerCredentials{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }
}
