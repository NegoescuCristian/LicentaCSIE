package licenta.persistence.dao;

import licenta.persistence.entities.UserEntity;

public interface UserDao extends AbstractDao<UserEntity>{
    
    UserEntity findByUsername(String userName);

}
