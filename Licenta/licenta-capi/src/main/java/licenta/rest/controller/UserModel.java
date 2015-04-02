package licenta.rest.controller;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UserModel")
public class UserModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private String role;
    
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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    
    
}
