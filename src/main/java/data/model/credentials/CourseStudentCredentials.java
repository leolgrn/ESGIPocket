package data.model.credentials;

public class CourseStudentCredentials {

    private String course;
    private Boolean vote;

    public CourseStudentCredentials(String course, Boolean vote) {
        this.course = course;
        this.vote = vote;
    }
}
