package licenta.persistence.entities;

import javax.persistence.*;
import ro.licenta.customer.models.UserRole;

import java.util.List;

@Entity
@Table(name="Customer")
public class UserEntity {

    @Id()
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String userName;
    private String firstName;
    private String lastName;
    private String address;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


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
