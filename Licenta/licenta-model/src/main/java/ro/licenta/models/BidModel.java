package ro.licenta.models;

/**
 * Created by churmuzache on 6/12/15.
 */
public class BidModel {

    private String userName;
    private long announceId;
    private long bidSum;

    public BidModel() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getAnnounceId() {
        return announceId;
    }

    public void setAnnounceId(long announceId) {
        this.announceId = announceId;
    }

    public long getBidSum() {
        return bidSum;
    }

    public void setBidSum(long bidSum) {
        this.bidSum = bidSum;
    }
}
