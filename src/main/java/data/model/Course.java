package data.model;

public class Course {

    private String title;
    private String archive;
    private String content;
    private String id;
    private Topic topic;
    private Class classe;
    private String updatedAt;
    private String createdAt;

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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Class getClasse() {
        return classe;
    }

    public void setClass(Class classe) {
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

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", archive='" + archive + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", topic=" + topic +
                ", classe='" + classe + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
