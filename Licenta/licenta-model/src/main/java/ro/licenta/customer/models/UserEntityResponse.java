package ro.licenta.customer.models;

/**
 * Created by churmuzache on 4/7/15.
 */
public class UserEntityResponse {

    private String userName;
    private String password;
    private UserRole userRole;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
