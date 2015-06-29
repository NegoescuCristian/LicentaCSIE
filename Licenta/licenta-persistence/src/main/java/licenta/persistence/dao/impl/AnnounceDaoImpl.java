package licenta.persistence.dao.impl;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import licenta.persistence.dao.AnnounceDao;
import licenta.persistence.entities.AnnounceEntity;
import licenta.persistence.entities.BidderEntity;
import licenta.persistence.entities.UserEntity;
import ro.licenta.customer.models.AnnounceDetailsComplexResponse;
import ro.licenta.customer.models.BidderDetailComplex;

public class AnnounceDaoImpl extends AbstractDaoImpl<AnnounceEntity> implements AnnounceDao {

    public AnnounceDaoImpl() {
        super(AnnounceEntity.class);
    }

    @Override
    public List<AnnounceEntity> getAnnounceByUserId(String userName) {
        final String query = "select a from AnnounceEntity a JOIN a.userEntity u where u.userName=(:user_name)";

        final Query queryM = this.entityManager.createQuery(query);
        queryM.setParameter("user_name", userName);

        List<AnnounceEntity> resultList = queryM.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList;

    }

    @Override
    public List<AnnounceEntity> getAllAnnounces() {
        final String query = "select a from AnnounceEntity a";
        final Query queryM = this.entityManager.createQuery(query);

        List<AnnounceEntity> resultList = queryM.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList;
    }

    @Override
    public AnnounceDetailsComplexResponse getAnnounceByAnnounceId(long announceId) {

        final String queryString = "select b from BidderEntity b " +
                "JOIN b.announceEntity a " +
                "JOIN b.userEntity u WHERE a.id=(:announce_id)";

        Query query = this.entityManager.createQuery(queryString);
        query.setParameter("announce_id",announceId);

        List<BidderEntity> bidders = query.getResultList();
        if (bidders == null || bidders.size() == 0) {
            return null;
        }
        List<BidderDetailComplex> complex = new LinkedList<>();
        for (BidderEntity b : bidders) {
            BidderDetailComplex details = new BidderDetailComplex();

            details.setUserName(b.getUserEntity().getUserName());
            details.setFirstName(b.getUserEntity().getUserDetailsEntity().getFirstName());
            details.setLastName(b.getUserEntity().getUserDetailsEntity().getLastName());
            details.setRegisterDate(b.getUserEntity().getUserDetailsEntity().getRegisterDate());
            details.setBiddedSum(b.getBidSum());

            complex.add(details);
        }

        AnnounceDetailsComplexResponse details = new AnnounceDetailsComplexResponse();
        AnnounceEntity announce = bidders.get(0).getAnnounceEntity();

        details.setAnnounceId(announce.getId());
        details.setStartDate(announce.getStartDate());
        details.setEndDate(announce.getEndDate());
        details.setCategory(announce.getCategory());
        details.setDescription(announce.getDescription());
        details.setBidderDetailComplexes(complex);
        details.setTitle(announce.getTitle());
        details.setStartSum(announce.getStartSum());
        details.setUserNameFounder(announce.getUserEntity().getUserName());

        return details;
    }

}
