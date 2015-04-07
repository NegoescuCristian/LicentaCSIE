package licenta.persistence.entities;

import javax.persistence.*;
import ro.licenta.customer.models.UserRole;

@Entity
@Table(name="Customer")
public class UserEntity {

    @Id()
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String userName;
    private String password;
    private UserRole userRole;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
