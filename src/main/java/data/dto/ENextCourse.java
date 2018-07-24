package data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ENextCourse {

    @SerializedName("beginning") private String beginning;
    @SerializedName("end") private String end;
    @SerializedName("subject") private String subject;
    @SerializedName("teachers") private ArrayList<String> teachers;

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<String> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "ENextCourse{" +
                "beginning='" + beginning + '\'' +
                ", end='" + end + '\'' +
                ", subject='" + subject + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
