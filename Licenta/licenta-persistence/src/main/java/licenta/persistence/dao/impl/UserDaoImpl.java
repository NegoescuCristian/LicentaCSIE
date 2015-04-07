package licenta.persistence.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import licenta.persistence.dao.UserDao;
import licenta.persistence.entities.UserEntity;

public class UserDaoImpl extends AbstractDaoImpl<UserEntity>implements UserDao {

    public UserDaoImpl(){
        super(UserEntity.class);
    }

    @Override
    public UserEntity findByUsernameAndPassword(String userName, String password) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb
                .createQuery(UserEntity.class);
        Root<UserEntity> user = cq.from(UserEntity.class);
        cq.select(user);
        Predicate condition = cb.and(cb.equal(user.get("userName"), userName), cb.equal(user.get("password"),password ));
        cq.where(condition);
        
        List<UserEntity> resultList = this.entityManager.createQuery(cq)
                .getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }

    @Override
    public UserEntity findByUsername(String userName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb
                .createQuery(UserEntity.class);
        Root<UserEntity> user = cq.from(UserEntity.class);
        cq.select(user);
        Predicate condition = cb.and(cb.equal(user.get("userName"), userName));
        cq.where(condition);

        List<UserEntity> resultList = this.entityManager.createQuery(cq)
                .getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }
}
