package ro.negoescu.licenta.user;

import licenta.persistence.dao.UserDao;
import licenta.persistence.entities.UserEntity;
import org.apache.commons.codec.binary.Base64;
import ro.licenta.customer.models.UserEntityResponse;
import org.apache.commons.codec.binary.Hex;
import ro.licenta.customer.models.UserRole;

/**
 * Created by churmuzache on 4/7/15.
 */
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao=userDao;
    }


    /**
     *
     * @param userId
     * @return
     */
    public UserEntityResponse getUserById(long userId) {
        UserEntityResponse response = new UserEntityResponse();

        UserEntity userEntity = userDao.findById(userId);
        if(userEntity == null) {
            return null;
        }else {
            response.setUserName(userEntity.getUserName());
            response.setPassword(Hex.encodeHexString(userEntity.getPassword().getBytes()));
            response.setUserRole(userEntity.getUserRole());
            return response;
        }
    }

    /**
     * TODO change the BUYER DEFAULT ROLE
     *
     * @param userName
     * @param password
     * @return
     */
    public boolean registerCustomer(String userName, String password, UserRole userRole) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword(Base64.encodeBase64String(password.getBytes()));
        userEntity.setUserRole(userRole);

        try {
            userDao.persist(userEntity);
        }catch( Exception exception ) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param userName
     * @return
     */
    public UserEntityResponse getUserByUserName(String userName) {
        UserEntityResponse response = new UserEntityResponse();

        UserEntity userEntity = userDao.findByUsername(userName);
        if(userEntity == null) {
            return null;
        }else {
            response.setUserName(userEntity.getUserName());
            response.setUserRole(userEntity.getUserRole());
            return response;
        }
    }

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    public boolean isValidUser(String userName, String password) {

        UserEntity entity = userDao.findByUsernameAndPassword(userName,Base64.encodeBase64String(password.getBytes()));
        if(entity == null) {
            return false;
        }
        return true;
    }


}
