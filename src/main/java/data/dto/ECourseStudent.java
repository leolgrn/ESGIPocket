package data.dto;

import com.google.gson.annotations.SerializedName;

public class ECourseStudent {

    @SerializedName("author") private Boolean author;
    @SerializedName("vote") private Boolean vote;
    @SerializedName("favorite") private Boolean favorite;
    @SerializedName("user") private EUser eUser;
    @SerializedName("course") private ECourse eCourse;
    @SerializedName("_id") private String id;

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

    public EUser geteUser() {
        return eUser;
    }

    public void seteUser(EUser eUser) {
        this.eUser = eUser;
    }

    public ECourse geteCourse() {
        return eCourse;
    }

    public void seteCourse(ECourse eCourse) {
        this.eCourse = eCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ECourseStudent{" +
                "author=" + author +
                ", vote=" + vote +
                ", favorite=" + favorite +
                ", eUser=" + eUser +
                ", eCourse=" + eCourse +
                ", id='" + id + '\'' +
                '}';
    }
}
