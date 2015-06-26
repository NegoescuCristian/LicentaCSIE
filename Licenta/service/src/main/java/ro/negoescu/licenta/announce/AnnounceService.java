package ro.negoescu.licenta.announce;

import licenta.persistence.dao.AnnounceDao;
import licenta.persistence.dao.BidderDao;
import licenta.persistence.dao.UserDao;
import licenta.persistence.entities.AnnounceEntity;

import licenta.persistence.entities.BidderEntity;
import licenta.persistence.entities.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.licenta.customer.models.AnnounceDetailsComplexResponse;
import ro.licenta.customer.models.AnnounceDetailsResponse;
import ro.licenta.customer.models.AnnounceModel;
import ro.licenta.customer.models.BidderDetail;
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
        if(announce.getEndDate() == null) {
            announceEntity.setEndDate(new Date());
        }else {
            announceEntity.setEndDate(announce.getEndDate());
        }

        try{
            announceDao.persist(announceEntity);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    public List<AnnounceDetailsResponse> getAnnounceDetails() {
        List<AnnounceEntity> announces = announceDao.getAllAnnounces();
        List<AnnounceDetailsResponse> response = new LinkedList();
        for(AnnounceEntity a : announces) {
            List<BidderDetail> bidders = new LinkedList<>();
            AnnounceDetailsResponse detailsResponse = new AnnounceDetailsResponse();
            detailsResponse.setTitle(a.getTitle());
            detailsResponse.setDescription(a.getDescription());
            detailsResponse.setCategory(a.getCategory());
            detailsResponse.setStartDate(a.getStartDate());
            detailsResponse.setEndDate(a.getEndDate());
            detailsResponse.setStartSum(a.getStartSum());
            detailsResponse.setBidderEntityList(bidders);
            detailsResponse.setAnnounceId(a.getId());

            response.add(detailsResponse);
        }

        return response;
    }

    public AnnounceDetailsComplexResponse getAnnounceByAnnounceId(long announceId) {
        AnnounceDetailsResponse detailResponse = new AnnounceDetailsResponse();
        AnnounceDetailsComplexResponse entity = announceDao.getAnnounceByAnnounceId(announceId);
        return entity;
    }

}
