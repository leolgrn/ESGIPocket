package data.model.credentials;

public class AnswerCredentials {

    private String content;
    private Boolean rightAnswer;

    public AnswerCredentials(String content, Boolean rightAnswer) {
        this.content = content;
        this.rightAnswer = rightAnswer;
    }

    public String getContent() {
        return content;
    }

    public Boolean getRightAnswer() {
        return rightAnswer;
    }

    @Override
    public String toString() {
        return "AnswerCredentials{" +
                "content='" + content + '\'' +
                ", rightAnswer=" + rightAnswer +
                '}';
    }
}
