package ro.negoescu.licenta.user;

import licenta.persistence.dao.AnnounceDao;
import licenta.persistence.dao.BidderDao;
import licenta.persistence.dao.UserDao;
import licenta.persistence.dao.UserDetailsDao;
import licenta.persistence.entities.AnnounceEntity;
import licenta.persistence.entities.BidderEntity;
import licenta.persistence.entities.UserDetailsEntity;
import licenta.persistence.entities.UserEntity;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.licenta.customer.models.AccountDetailsResponse;
import ro.licenta.customer.models.AnnounceDetailsResponse;
import ro.licenta.customer.models.AnnounceModel;
import ro.licenta.customer.models.UserEntityResponse;

import org.apache.commons.codec.binary.Hex;

import ro.licenta.models.UserModel;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by negoescu.cristi on 4/7/15.
 */
public class UserService {


    private Logger logger = LoggerFactory.getLogger(UserService.class);

    /** The user dao **/
    private UserDao userDao;

    /** The user details dao**/
    private UserDetailsDao userDetailsDao;

    /** The announce dao **/
    private AnnounceDao announceDao;

    /** The bidder dao **/
    private BidderDao bidderDao;

    public UserService(UserDao userDao, UserDetailsDao userDetailsDao, AnnounceDao announceDao, BidderDao bidderDao) {
        this.userDao=userDao;
        this.userDetailsDao = userDetailsDao;
        this.announceDao = announceDao;
        this.bidderDao = bidderDao;
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
        userDetails.setRegisterDate(new Date());

        userEntity.setPassword(Base64.encodeBase64String(userModel.getPassword().getBytes()));
        userEntity.setUserRole(userModel.getUserRole());
        userEntity.setUserDetailsEntity(userDetails);

        try {
            logger.info("Persisting user details for username:"+userEntity.getUserName());
            userDetailsDao.persist(userDetails);
            logger.info("Persisting the user entity:"+userEntity.getUserName());
            userDao.persist(userEntity);
        }catch(Exception exception ) {
            exception.printStackTrace();
            logger.info(exception.getMessage());
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
     * Check if a user is valid or not
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
     * Returns the account details for a specific user name.
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

    /**
     * Return the announce details for a specific user name.
     *
     * @param userName
     * @return
     */
    public List<AnnounceDetailsResponse> getAnnounceDetailsByUserName(String userName) {
        List<AnnounceDetailsResponse> detailsResponse = new LinkedList<>();

        List<AnnounceEntity> announces = announceDao.getAnnounceByUserId(userName);
        if(announces == null) {
            logger.info("No announces were found for userName:%s",userName);
        }

        for(AnnounceEntity entity : announces) {
            AnnounceDetailsResponse response = new AnnounceDetailsResponse();

            response.setCategory(entity.getCategory());
            response.setDescription(entity.getDescription());
            response.setStartSum(entity.getStartSum());
            response.setTitle(entity.getTitle());

            detailsResponse.add(response);
        }

        return detailsResponse;
    }

    public List<AnnounceDetailsResponse> getAllAnnounceDetailsByUserName(String userName) {
        List<AnnounceDetailsResponse> detailsResponse = new LinkedList<>();

        List<BidderEntity> announces = bidderDao.getAllBiddingDetails(userName);
        if(announces == null) {
            logger.info("No announces were found for userName:%s",userName);
        }

        for(BidderEntity entity : announces) {
            AnnounceDetailsResponse response = new AnnounceDetailsResponse();

            //response.setCategory(entity.getAnnounceEntity().getCategory());
            //response.setDescription(entity.getDescription());
            //response.setStartSum(entity.getStartSum());
            //response.setTitle(entity.getTitle());

            detailsResponse.add(response);
        }

        return detailsResponse;
    }

}
