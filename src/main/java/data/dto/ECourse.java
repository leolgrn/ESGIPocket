package data.dto;

import com.google.gson.annotations.SerializedName;

public class ECourse {

    @SerializedName("title") private String title;
    @SerializedName("archive") private String archive;
    @SerializedName("content") private String content;
    @SerializedName("_id") private String id;
    @SerializedName("topic") private ETopic topic;
    @SerializedName("class") private String classId;
    @SerializedName("updatedAt") private String updatedAt;
    @SerializedName("createdAt") private String createdAt;

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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
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

    @Override
    public String toString() {
        return "ECourse{" +
                "title='" + title + '\'' +
                ", archive='" + archive + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", topic=" + topic +
                ", classId='" + classId + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
