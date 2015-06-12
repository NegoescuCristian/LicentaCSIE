package ro.negoescu.licenta.announce;

import licenta.persistence.dao.AnnounceDao;
import licenta.persistence.dao.UserDao;
import licenta.persistence.entities.AnnounceEntity;

import licenta.persistence.entities.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.licenta.customer.models.AnnounceDetailsResponse;
import ro.licenta.customer.models.AnnounceModel;
import ro.negoescu.licenta.user.UserService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class AnnounceService {

    protected static final Logger logger = LoggerFactory.getLogger(AnnounceService.class);

    /** The announce dao **/
    private AnnounceDao announceDao;
    /** The user dao **/
    private UserDao userDao;

    public AnnounceService(AnnounceDao announceDao, UserDao userDao){
        this.userDao = userDao;
        this.announceDao = announceDao;
    }
    
    
    public boolean registerAnnounce(AnnounceModel announce, String userName){

        UserEntity userEntity = userDao.findByUsername(userName);
        if(userEntity == null) {
            logger.info("No user was found for user name %s",userName);
            return false;
        }

        AnnounceEntity announceEntity = new AnnounceEntity();
        announceEntity.setCategory(announce.getCategory());
        announceEntity.setDescription(announce.getDescription());
        announceEntity.setTitle(announce.getTitle());
        announceEntity.setStartDate(new Date());
        announceEntity.setStartSum(announce.getStartSum());
        announceEntity.setImagePath(announce.getImagePath());
        announceEntity.setUserEntity(userEntity);
        announceEntity.setEndDate(announce.getEndDate());
        try{
            announceDao.persist(announceEntity);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

}
