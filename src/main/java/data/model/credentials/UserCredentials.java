package data.model.credentials;

public class UserCredentials {

    private String firstname;
    private String lastname;
    private String email;
    private Boolean activated;
    private int role;

    public UserCredentials(String firstname, String lastname, String email, Boolean activated, int role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.activated = activated;
        this.role = role;
    }
}
