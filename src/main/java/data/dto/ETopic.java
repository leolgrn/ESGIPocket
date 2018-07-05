package data.dto;

import com.google.gson.annotations.SerializedName;

public class ETopic {

    @SerializedName("name") private String name;
    @SerializedName("_id") private String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ETopic{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
