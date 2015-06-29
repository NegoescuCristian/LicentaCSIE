package ro.negoescu.licenta.bid;

import licenta.persistence.dao.AnnounceDao;
import licenta.persistence.dao.BidderDao;
import licenta.persistence.dao.UserDao;
import licenta.persistence.entities.AnnounceEntity;
import licenta.persistence.entities.BidderEntity;
import licenta.persistence.entities.UserEntity;
import org.jboss.logging.Logger;
import ro.licenta.models.BidModel;

/**
 * Created by churmuzache on 6/12/15.
 */
public class BidderService {

    protected static final Logger logger = Logger.getLogger(BidderService.class);

    private BidderDao bidderDao;
    private UserDao userDao;
    private AnnounceDao announceDao;

    public BidderService(BidderDao bidderDao, UserDao userDao, AnnounceDao announceDao) {
        this.bidderDao=bidderDao;
        this.userDao=userDao;
        this.announceDao=announceDao;
    }

    public boolean makeBid(BidModel bidModel) {

        BidderEntity bidderEntity = new BidderEntity();

        UserEntity userEntity = userDao.findByUsername(bidModel.getUserName());

        if(userEntity == null) {
            logger.info("The user name "+bidModel.getUserName()+" was not found");
            return false;
        }

        AnnounceEntity announceEntity = announceDao.findById(bidModel.getAnnounceId());

        if(announceEntity == null) {
            logger.info("The announce with id "+bidModel.getAnnounceId()+" was not found");
            return false;
        }

        if(announceEntity.getUserEntity().getUserName().equals(bidModel.getUserName())) {
            logger.info("the user with user name "+bidModel.getUserName()+" cannot bid on its own announce");
            return false;
        }

        bidderEntity.setBidSum(bidModel.getBidSum());
        bidderEntity.setAnnounceEntity(announceEntity);
        bidderEntity.setUserEntity(userEntity);

        try {
            bidderDao.persist(bidderEntity);
        }catch(Exception exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
    }
}
