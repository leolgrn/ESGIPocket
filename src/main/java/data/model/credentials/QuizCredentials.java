package data.model.credentials;

import java.util.ArrayList;

public class QuizCredentials {

    private String name;
    private String topic;
    private ArrayList<QuestionAndAnswerCredentials> content;

    public QuizCredentials(String name, String topic, ArrayList<QuestionAndAnswerCredentials> content) {
        this.name = name;
        this.topic = topic;
        this.content = content;
    }

    public QuizCredentials(String name, String topic) {
        this.name = name;
        this.topic = topic;
    }

    public ArrayList<QuestionAndAnswerCredentials> getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "QuizCredentials{" +
                "name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", content=" + content +
                '}';
    }
}
