package data.model.credentials;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassCredentials {

    private String year;
    private String group;
    private String speciality;
    private String[] topics;

    public ClassCredentials(String year, String group, String speciality, String[] topics) {
        this.year = year;
        this.group = group;
        this.speciality = speciality;
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "ClassCredentials{" +
                "year='" + year + '\'' +
                ", group='" + group + '\'' +
                ", speciality='" + speciality + '\'' +
                ", topics=" + Arrays.toString(topics) +
                '}';
    }
}
