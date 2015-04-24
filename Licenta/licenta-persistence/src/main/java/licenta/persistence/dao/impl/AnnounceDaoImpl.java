package licenta.persistence.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import licenta.persistence.dao.AnnounceDao;
import licenta.persistence.entities.AnnounceEntity;
import licenta.persistence.entities.UserEntity;

public class AnnounceDaoImpl extends AbstractDaoImpl<AnnounceEntity> implements AnnounceDao{

    public AnnounceDaoImpl(){
        super(AnnounceEntity.class);
    }

    @Override
    public List<AnnounceEntity> getAnnounceByUserId(long userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AnnounceEntity> cq = cb
                .createQuery(AnnounceEntity.class);
        Root<AnnounceEntity> user = cq.from(AnnounceEntity.class);
        cq.select(user);
        Predicate condition = cb.and(cb.equal(user.get("userId"), userId));
        cq.where(condition);
        
        List<AnnounceEntity> resultList = this.entityManager.createQuery(cq)
                .getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList;
        
    }
    
    
}
