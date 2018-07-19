package data.model;

public class Answer {

    private String content;
    private Boolean rightAnswer;
    private Question question;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "content='" + content + '\'' +
                ", rightAnswer=" + rightAnswer +
                ", question=" + question +
                '}';
    }
}
