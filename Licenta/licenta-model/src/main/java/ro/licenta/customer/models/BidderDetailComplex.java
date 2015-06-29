package ro.licenta.customer.models;

import java.util.Date;

/**
 * Created by churmuzache on 6/25/15.
 */
public class BidderDetailComplex {

    private String userName;
    private Date registerDate;
    private String firstName;
    private String lastName;
    private long biddedSum;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

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

    public long getBiddedSum() {
        return biddedSum;
    }

    public void setBiddedSum(long biddedSum) {
        this.biddedSum = biddedSum;
    }
}
