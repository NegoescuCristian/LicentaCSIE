package licenta.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import licenta.persistence.dao.AnnounceDao;
import licenta.persistence.entities.AnnounceEntity;
import licenta.persistence.entities.UserEntity;

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

}
