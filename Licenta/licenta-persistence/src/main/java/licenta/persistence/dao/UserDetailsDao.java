package licenta.persistence.dao;

import licenta.persistence.entities.UserDetailsEntity;

public interface UserDetailsDao extends AbstractDao<UserDetailsEntity>{

    /**
     *
     * @param userName
     * @return
     */
    UserDetailsEntity getUserDetailsByUserName(String userName);

}
