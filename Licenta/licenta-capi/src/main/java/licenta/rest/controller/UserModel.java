package licenta.rest.controller;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import ro.licenta.customer.models.UserRole;

@XStreamAlias("UserModel")
public class UserModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;

    private UserRole userRole;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
