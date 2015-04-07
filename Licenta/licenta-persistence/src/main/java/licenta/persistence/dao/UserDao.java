package licenta.persistence.dao;

import licenta.persistence.entities.UserEntity;

public interface UserDao extends AbstractDao<UserEntity>{

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    UserEntity findByUsernameAndPassword(String userName, String password);

    /**
     *
     * @param userName
     * @return
     */
    UserEntity findByUsername(String userName);

}
