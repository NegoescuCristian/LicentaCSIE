package licenta.persistence.entities;

import javax.persistence.*;

/**
 * Created by churmuzache on 4/28/15.
 */
@Entity
@Table(name="Bidder")
public class BidderEntity {

    @Id
    @GeneratedValue()
    private long id;
    private long bidSum;
    @OneToOne(fetch = FetchType.EAGER)
    private UserEntity userEntity;

    public AnnounceEntity getAnnounceEntity() {
        return announceEntity;
    }

    public void setAnnounceEntity(AnnounceEntity announceEntity) {
        this.announceEntity = announceEntity;
    }

    public long getBidSum() {
        return bidSum;
    }

    public void setBidSum(long bidSum) {
        this.bidSum = bidSum;
    }

    @OneToOne(fetch = FetchType.EAGER)
    private AnnounceEntity announceEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
