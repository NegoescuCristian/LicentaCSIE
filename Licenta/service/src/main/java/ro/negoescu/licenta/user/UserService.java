package ro.negoescu.licenta.user;

import licenta.persistence.dao.AnnounceDao;
import licenta.persistence.dao.UserDao;
import licenta.persistence.entities.AnnounceEntity;
import licenta.persistence.entities.UserDetailsEntity;
import licenta.persistence.entities.UserEntity;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.licenta.customer.models.AccountDetailsResponse;
import ro.licenta.customer.models.AnnounceModel;
import ro.licenta.customer.models.UserEntityResponse;

import org.apache.commons.codec.binary.Hex;

import ro.licenta.models.UserModel;

/**
 * Created by churmuzache on 4/7/15.
 */
public class UserService {


    private Logger logger = LoggerFactory.getLogger(UserService.class);

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
            logger.error("No user was found for user id <%s>",userId);
            return null;
        }else {
            response.setUserName(userEntity.getUserName());
            response.setPassword(Hex.encodeHexString(userEntity.getPassword().getBytes()));
            response.setUserRole(userEntity.getUserRole());
            return response;
        }
    }

    /**
     *
     * @return
     */
    public boolean registerCustomer(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userModel.getUserName());

        UserDetailsEntity userDetails = new UserDetailsEntity();
        userDetails.setFirstName(userModel.getFirstName());
        userDetails.setLastName(userModel.getLastName());
        userDetails.setAddress(userModel.getAddress());

        userEntity.setPassword(Base64.encodeBase64String(userModel.getPassword().getBytes()));
        userEntity.setUserRole(userModel.getUserRole());
        userEntity.setUserDetailsEntity(userDetails);

        try {
            userDao.persist(userEntity);
        }catch(Exception exception ) {
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
            logger.error("No user was found for userName <%s>",userName);
            return null;
        }else {
            response.setUserName(userEntity.getUserName());
            response.setUserRole(userEntity.getUserRole());
            response.setPassword(Hex.encodeHexString(userEntity.getPassword().getBytes()));
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
            logger.error("No user was found for userName <%s>",userName);
            return false;
        }
        return true;
    }

    /**
     *
     * @param userName
     * @return
     */
    public AccountDetailsResponse getAccountDetails(String userName) {
        AccountDetailsResponse detailsResponse = new AccountDetailsResponse();

        UserEntity userEntity = userDao.findByUsername(userName);
        if(userEntity == null) {
            logger.error("No user was found for userName <%s>",userName);
            return null;
        } else {
            UserDetailsEntity userDetailsEntity = userEntity.getUserDetailsEntity();
            detailsResponse.setFirstName(userDetailsEntity.getFirstName());
            detailsResponse.setLastName(userDetailsEntity.getLastName());
            detailsResponse.setAddress(userDetailsEntity.getAddress());
            detailsResponse.setUserName(userEntity.getUserName());
        }

        return detailsResponse;
    }
    

}
