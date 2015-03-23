package licenta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpa.HibernatePersistenceProvider;

import licenta.persistence.dao.impl.CustomerDaoImpl;
import licenta.persistence.entities.CustomerEntity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
       /* EntityManagerFactory emfactory =  HibernatePersistenceProvider.createEntityManagerFactory( "persistence.xml" );
        
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        customerDao.setEntityManager(entitymanager);
        
        CustomerEntity customer = new CustomerEntity();
        customer.setName("bibi");
        
        customerDao.persist(customer);
        entitymanager.persist(customer);

        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        emfactory.close( );
        */
        
    }
}
