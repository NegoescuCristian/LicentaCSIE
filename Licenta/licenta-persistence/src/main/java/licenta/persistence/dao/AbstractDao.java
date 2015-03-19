package licenta.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface AbstractDao<T> {

    void persist(T entity);

    void remove(T entity);

    void update(final T entity);

    List<T> findAll();

    T findById(long id);

    EntityManager getEntityManager();
}
