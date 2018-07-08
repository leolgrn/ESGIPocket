package data.model;

public class Class {

    private Year year;
    private Group group;
    private Speciality speciality;

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

    @Override
    public String toString() {
        return "Class{" +
                "year=" + year +
                ", group=" + group +
                ", speciality=" + speciality +
                '}';
    }
}
