package data.dto;

import com.google.gson.annotations.SerializedName;

public class EUser {

    @SerializedName("firstname") private String firstname;
    @SerializedName("lastname") private String lastname;
    @SerializedName("email") private String email;
    @SerializedName("password") private String password;
    @SerializedName("activationCode") private int activationCode;
    @SerializedName("activated") private Boolean activated;
    @SerializedName("role") private int role;
    @SerializedName("class") private String classId;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getActivationCode() {
        return activationCode;
    }

    public Boolean getActivated() {
        return activated;
    }

    public int getRole() {
        return role;
    }

    public String getClassId() {
        return classId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivationCode(int activationCode) {
        this.activationCode = activationCode;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "EUser{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", activationCode=" + activationCode +
                ", activated=" + activated +
                ", role=" + role +
                ", classId='" + classId + '\'' +
                '}';
    }
}
