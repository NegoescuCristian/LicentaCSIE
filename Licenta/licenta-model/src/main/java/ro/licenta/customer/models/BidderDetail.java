package ro.licenta.customer.models;

/**
 * Created by churmuzache on 6/11/15.
 */
public class BidderDetail {

    private String userName;
    private long bidSum;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getBidSum() {
        return bidSum;
    }

    public void setBidSum(long bidSum) {
        this.bidSum = bidSum;
    }
}
