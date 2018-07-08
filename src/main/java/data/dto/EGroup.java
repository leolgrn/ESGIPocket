package data.dto;

import com.google.gson.annotations.SerializedName;

public class EGroup {

    @SerializedName("name") private String name;
    @SerializedName("number") private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "EGroup{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
