package data.model;

import java.util.ArrayList;

public class Class {

    private Year year;
    private Group group;
    private Speciality speciality;
    private ArrayList<Topic> topics;

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public ArrayList<Topic> getTopic() {
        return topics;
    }

    public void setTopic(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Class{" +
                "year=" + year +
                ", group=" + group +
                ", speciality=" + speciality +
                ", topics=" + topics +
                '}';
    }
}
