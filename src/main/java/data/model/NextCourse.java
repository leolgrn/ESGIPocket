package data.model;

import java.util.ArrayList;

public class NextCourse {

    private String beginning;
    private String end;
    private String subject;
    private ArrayList<String> teachers;

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
        return "NextCourse{" +
                "beginning='" + beginning + '\'' +
                ", end='" + end + '\'' +
                ", subject='" + subject + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
