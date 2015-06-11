package licenta.persistence.dao.impl;

import licenta.persistence.dao.BidderDao;
import licenta.persistence.entities.BidderEntity;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by churmuzache on 6/11/15.
 */
public class BidderDaoImpl extends AbstractDaoImpl<BidderEntity> implements BidderDao {

    public BidderDaoImpl() {
        super(BidderEntity.class);
    }

    @Override
    public List<BidderEntity> getAllBiddingDetails(String userName) {
        final String queryString = "select b from BidderEntity b JOIN UserEntity u where u.userName=(:user_name)";
        final Query query = this.entityManager.createQuery(queryString);
        List<BidderEntity> bidders = query.getResultList();

        return bidders;
    }
}
