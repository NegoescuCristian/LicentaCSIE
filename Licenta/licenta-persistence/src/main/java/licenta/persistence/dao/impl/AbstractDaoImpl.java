package licenta.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import licenta.persistence.dao.AbstractDao;

@Transactional
@Repository
public class AbstractDaoImpl<T> implements AbstractDao<T>{

    protected Class<T> entityClass;

    @PersistenceContext(unitName = "testPersistence")
    @Qualifier(value = "entityManagerFactory")
    protected EntityManager entityManager;
    
    public AbstractDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractDaoImpl() {

    }
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(T entity) {
        System.out.println("persist========="+entity.toString());
        entityManager.persist(entity);
    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entityManager.merge(entity));
        
    }

    @Override
    public void update(T entity) {
       entityManager.merge(entity);
        
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public T findById(long id) {
        System.out.println(entityClass.toString());
        return entityManager.find(entityClass, id);
    }

    @Override
    public List findAll() {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> items = criteriaQuery.from(entityClass);
        criteriaQuery.select(items);

        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }
}
