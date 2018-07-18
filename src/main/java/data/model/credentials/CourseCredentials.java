package data.model.credentials;

public class CourseCredentials {

    private String title;
    private String classe;
    private String topic;
    private Boolean archive;

    public CourseCredentials(String title, String classe, String topic, Boolean archive) {
        this.title = title;
        this.classe = classe;
        this.topic = topic;
        this.archive = archive;
    }
}
