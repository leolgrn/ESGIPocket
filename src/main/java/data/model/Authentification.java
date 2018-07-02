package data.model;

public class Authentification {

    private String token;
    private User user;
    private static Authentification INSTANCE = new Authentification();

    private Authentification(){}

    public static Authentification getInstance(){
        return INSTANCE;
    }

    public static void setInstance(Authentification authentification){
        INSTANCE = authentification;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Authentification{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
