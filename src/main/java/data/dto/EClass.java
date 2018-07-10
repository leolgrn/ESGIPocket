package data.dto;

import com.google.gson.annotations.SerializedName;
import data.model.Group;
import data.model.Speciality;
import data.model.Year;

import java.util.ArrayList;

public class EClass {

    @SerializedName("year") private EYear eYear;
    @SerializedName("group") private EGroup eGroup;
    @SerializedName("speciality") private ESpeciality eSpeciality;
    @SerializedName("topics") private ArrayList<ETopic> topics;

    public EYear geteYear() {
        return eYear;
    }

    public void seteYear(EYear eYear) {
        this.eYear = eYear;
    }

    public EGroup geteGroup() {
        return eGroup;
    }

    public void seteGroup(EGroup eGroup) {
        this.eGroup = eGroup;
    }

    public ESpeciality geteSpeciality() {
        return eSpeciality;
    }

    public void seteSpeciality(ESpeciality eSpeciality) {
        this.eSpeciality = eSpeciality;
    }

    public ArrayList<ETopic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<ETopic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "EClass{" +
                "eYear=" + eYear +
                ", eGroup=" + eGroup +
                ", eSpeciality=" + eSpeciality +
                ", topics=" + topics +
                '}';
    }
}
