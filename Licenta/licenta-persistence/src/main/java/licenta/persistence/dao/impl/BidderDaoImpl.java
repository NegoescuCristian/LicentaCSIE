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
        final String queryString = "select b from BidderEntity b JOIN b.userEntity u where u.userName=(:user_name)";
        final Query query = this.entityManager.createQuery(queryString);
        List<BidderEntity> bidders = query.getResultList();

        query.setParameter("user_name", userName);

        return bidders;
    }

    @Override
    public List<BidderEntity> getBiddersForAnnounces(List<Long> announceIds) {
        final String queryString = "select b from BidderEntity b JOIN b.announceEntity a where a.id in (:ids)";
        final Query query = this.entityManager.createQuery(queryString);

        query.setParameter("ids", announceIds);

        return query.getResultList();
    }

    @Override
    public List<BidderEntity> getBiddersForAnnounce(long announceId) {
        final String queryString = "select b from BidderEntity b JOIN b.announceEntity a where a.id = (:id)";
        final Query query = this.entityManager.createQuery(queryString);

        query.setParameter("id", announceId);

        return query.getResultList();
    }

}
