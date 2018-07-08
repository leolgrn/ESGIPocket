package data.model;

public class Question {

    private String content;
    private Quiz quiz;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", quiz=" + quiz +
                '}';
    }
}
