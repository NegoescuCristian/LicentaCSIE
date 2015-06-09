package licenta.persistence.dao.impl;

import licenta.persistence.dao.UserDetailsDao;
import licenta.persistence.entities.UserDetailsEntity;
import licenta.persistence.entities.UserEntity;

public class UserDetailsDaoImpl extends AbstractDaoImpl<UserDetailsEntity> implements UserDetailsDao{

    
    public UserDetailsDaoImpl(){
        super(UserDetailsEntity.class);
    }
}
