package licenta.persistence.dao;

import licenta.persistence.entities.AnnounceEntity;
import licenta.persistence.entities.BidderEntity;

import java.util.List;

/**
 * Created by churmuzache on 6/11/15.
 */
public interface BidderDao extends AbstractDao<BidderEntity> {

    List<BidderEntity> getAllBiddingDetails(String userName);

}
