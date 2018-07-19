package data.dto;

import com.google.gson.annotations.SerializedName;

public class EAnswer {

    @SerializedName("content") private String content;
    @SerializedName("rightAnswer") private Boolean rightAnswer;
    @SerializedName("question") private EQuestion eQuestion;
    @SerializedName("_id") private String id;

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

    public EQuestion geteQuestion() {
        return eQuestion;
    }

    public void seteQuestion(EQuestion eQuestion) {
        this.eQuestion = eQuestion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EAnswer{" +
                "content='" + content + '\'' +
                ", rightAnswer=" + rightAnswer +
                ", eQuestion=" + eQuestion +
                ", id='" + id + '\'' +
                '}';
    }
}
