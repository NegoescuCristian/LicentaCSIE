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

    @OneToOne(fetch = FetchType.EAGER)
    private UserEntity userEntity;


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
