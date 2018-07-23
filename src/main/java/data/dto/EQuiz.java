package data.dto;

import com.google.gson.annotations.SerializedName;

public class EQuiz {

    @SerializedName("name") private String name;
    @SerializedName("topic") private ETopic eTopic;
    @SerializedName("user") private EUser eUser;
    @SerializedName("_id") private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ETopic geteTopic() {
        return eTopic;
    }

    public void seteTopic(ETopic eTopic) {
        this.eTopic = eTopic;
    }

    public EUser geteUser() {
        return eUser;
    }

    public void seteUser(EUser eUser) {
        this.eUser = eUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EQuiz{" +
                "name='" + name + '\'' +
                ", eTopic=" + eTopic +
                ", eUser=" + eUser +
                ", id='" + id + '\'' +
                '}';
    }
}
