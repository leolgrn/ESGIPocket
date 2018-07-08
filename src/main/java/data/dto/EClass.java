package data.dto;

import com.google.gson.annotations.SerializedName;
import data.model.Group;
import data.model.Speciality;
import data.model.Year;

public class EClass {

    @SerializedName("year") private EYear eYear;
    @SerializedName("group") private EGroup eGroup;
    @SerializedName("speciality") private ESpeciality eSpeciality;

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

    @Override
    public String toString() {
        return "EClass{" +
                "eYear=" + eYear +
                ", eGroup=" + eGroup +
                ", eSpeciality=" + eSpeciality +
                '}';
    }
}
