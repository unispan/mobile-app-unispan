package pe.com.unispan.mobile.model;

/**
 * Created by emarquez on 01/10/16.
 */
public class User {
    private static User ourInstance = new User();

    public static User getInstance() {
        return ourInstance;
    }

    private User() {
    }

    private String login;
    private String userName;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
