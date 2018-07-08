package data.dto;

import com.google.gson.annotations.SerializedName;

public class ESpeciality {

    @SerializedName("name") private String name;
    @SerializedName("acronym") private String acronym;

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
        return "ESpeciality{" +
                "name='" + name + '\'' +
                ", acronym='" + acronym + '\'' +
                '}';
    }
}
