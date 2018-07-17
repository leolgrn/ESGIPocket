package data.dto;

import com.google.gson.annotations.SerializedName;

public class ECourse {

    @SerializedName("title") private String title;
    @SerializedName("archive") private String archive;
    @SerializedName("content") private String content;
    @SerializedName("_id") private String id;
    @SerializedName("topic") private ETopic topic;
    @SerializedName("class") private EClass classe;
    @SerializedName("updatedAt") private String updatedAt;
    @SerializedName("createdAt") private String createdAt;
    @SerializedName("user") private EUser user;
    @SerializedName("like") private int like;
    @SerializedName("dislike") private int dislike;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ETopic getTopic() {
        return topic;
    }

    public void setTopic(ETopic topic) {
        this.topic = topic;
    }

    public EClass getClasse() {
        return classe;
    }

    public void setClass(EClass classId) {
        this.classe = classe;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EUser getUser() {
        return user;
    }

    public void setUser(EUser user) {
        this.user = user;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    @Override
    public String toString() {
        return "ECourse{" +
                "title='" + title + '\'' +
                ", archive='" + archive + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", topic=" + topic +
                ", classe=" + classe +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", user=" + user +
                ", like=" + like +
                ", dislike=" + dislike +
                '}';
    }
}
