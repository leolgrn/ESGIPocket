package data.model.credentials;

public class CourseCredentials {

    private String title;
    private String topic;
    private Boolean archive;
    private String content;
    private String url;
    private String classe;

    public CourseCredentials(String title, String topic, Boolean archive) {
        this.title = title;
        this.topic = topic;
        this.archive = archive;
    }

    public CourseCredentials(String title, String topic, Boolean archive, String content, String url, String classe, String user) {
        this.title = title;
        this.topic = topic;
        this.archive = archive;
        this.content = content;
        this.url = url;
        this.classe = classe;
    }
}
