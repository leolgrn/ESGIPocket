package data.dto;

import com.google.gson.annotations.SerializedName;

public class EQuestion {

    @SerializedName("content") private String content;
    @SerializedName("quiz") private EQuiz eQuiz;
    @SerializedName("_id") private String id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EQuiz geteQuiz() {
        return eQuiz;
    }

    public void seteQuiz(EQuiz eQuiz) {
        this.eQuiz = eQuiz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EQuestion{" +
                "content='" + content + '\'' +
                ", eQuiz=" + eQuiz +
                ", id='" + id + '\'' +
                '}';
    }
}
