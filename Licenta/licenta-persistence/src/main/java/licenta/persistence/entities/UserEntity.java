package licenta.persistence.entities;

import javax.persistence.*;


@Entity
@Table(name="Customer")
public class UserEntity {

    @Id()
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String userName;
    private String password;
    
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
