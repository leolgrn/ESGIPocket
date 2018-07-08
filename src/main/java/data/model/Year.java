package data.model;

public class Year {

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

    @Override
    public String toString() {
        return "Year{" +
                "name='" + name + '\'' +
                ", acronym='" + acronym + '\'' +
                '}';
    }

}
