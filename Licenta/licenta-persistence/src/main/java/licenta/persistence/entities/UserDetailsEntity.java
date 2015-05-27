package licenta.persistence.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by churmuzache on 5/27/15.
 */
@Entity
@Table(name="UserDetails")
public class UserDetailsEntity {
    @Id()
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private Date birthDate;
    private Date registerDate;


    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

}
