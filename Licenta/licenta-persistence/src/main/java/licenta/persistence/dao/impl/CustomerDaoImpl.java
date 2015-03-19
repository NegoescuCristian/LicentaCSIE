package licenta.persistence.dao.impl;

import licenta.persistence.dao.CustomerDao;
import licenta.persistence.entities.CustomerEntity;

public class CustomerDaoImpl extends AbstractDaoImpl<CustomerEntity>implements CustomerDao {

    public CustomerDaoImpl(){
        super(CustomerEntity.class);
    }
}
