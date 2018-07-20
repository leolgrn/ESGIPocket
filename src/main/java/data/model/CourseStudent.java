package data.model;

public class CourseStudent {

    private Boolean author;
    private Boolean vote;
    private Boolean favorite;
    private User user;
    private Course course;
    private String id;

    public Boolean getAuthor() {
        return author;
    }

    public void setAuthor(Boolean author) {
        this.author = author;
    }

    public Boolean getVote() {
        return vote;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CourseStudent{" +
                "author=" + author +
                ", vote=" + vote +
                ", favorite=" + favorite +
                ", user=" + user +
                ", course=" + course +
                ", id='" + id + '\'' +
                '}';
    }
}
