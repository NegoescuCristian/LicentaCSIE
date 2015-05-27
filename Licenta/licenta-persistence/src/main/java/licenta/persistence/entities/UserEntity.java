package licenta.persistence.entities;

import javax.persistence.*;
import ro.licenta.customer.models.UserRole;

import java.util.List;

@Entity

@Table(name="Customer")
public class UserEntity {

    @Id
    @GeneratedValue()
    private long id;
    @Column(unique = true)
    private String userName;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToOne(fetch = FetchType.EAGER)
    private UserDetailsEntity userDetailsEntity;

    public UserDetailsEntity getUserDetailsEntity() {
        return userDetailsEntity;
    }

    public void setUserDetailsEntity(UserDetailsEntity userDetailsEntity) {
        this.userDetailsEntity = userDetailsEntity;
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
