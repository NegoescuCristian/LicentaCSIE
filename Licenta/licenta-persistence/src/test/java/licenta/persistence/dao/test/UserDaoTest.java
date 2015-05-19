package licenta.persistence.dao.test;

import licenta.persistence.dao.impl.UserDaoImpl;

public class UserDaoTest extends AbstractDaoTest{
    
    protected UserDaoImpl userDaoImpl;
    
    protected void setDaos() {
        userDaoImpl = new UserDaoImpl();
        userDaoImpl.setEntityManager(entityManager);
        
        
    }

}
