package data.dto;

import com.google.gson.annotations.SerializedName;

public class EAuthentification {

    @SerializedName("token") private String token;
    @SerializedName("user") private EUser eUser;

    public String getToken() {
        return token;
    }

    public EUser geteUser() {
        return eUser;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void seteUser(EUser eUser) {
        this.eUser = eUser;
    }

    @Override
    public String toString() {
        return "EAuthentification{" +
                "token='" + token + '\'' +
                ", eUser=" + eUser +
                '}';
    }
}
