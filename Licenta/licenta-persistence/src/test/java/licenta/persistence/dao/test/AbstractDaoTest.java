package licenta.persistence.dao.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.DatabaseUnitException;
import org.hibernate.HibernateException;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import junit.framework.Assert;

public class AbstractDaoTest {
    
    private static EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;

    @BeforeClass
    public static void initEntityManager() throws HibernateException, DatabaseUnitException {
        entityManagerFactory = Persistence.createEntityManagerFactory("testPersistence");
        Assert.assertNotNull(entityManagerFactory);
        entityManager = entityManagerFactory.createEntityManager();
        Assert.assertNotNull(entityManager);
    }

    @AfterClass
    public static void closeEntityManager() {
        if (entityManager != null) {
            entityManager.close();
        }
    }

}
