package data.model;

import java.util.Objects;

public class Speciality {

    private String id;
    private String name;
    private String acronym;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(acronym, that.acronym);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, acronym);
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", acronym='" + acronym + '\'' +
                '}';
    }
}
