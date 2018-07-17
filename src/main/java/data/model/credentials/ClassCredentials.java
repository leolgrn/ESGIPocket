package data.model.credentials;

import java.util.ArrayList;

public class ClassCredentials {

    private String year;
    private String group;
    private String speciality;
    private ArrayList<String> topics;

    public ClassCredentials(String year, String group, String speciality, ArrayList<String> topics) {
        this.year = year;
        this.group = group;
        this.speciality = speciality;
        this.topics = topics;
    }
}
