package ro.negoescu.licenta.announce;

import licenta.persistence.dao.AnnounceDao;
import licenta.persistence.entities.AnnounceEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.licenta.customer.models.AnnounceModel;
import ro.negoescu.licenta.user.UserService;

public class AnnounceService {

    private Logger logger = LoggerFactory.getLogger(AnnounceService.class);

    private AnnounceDao announceDao;
    
    public AnnounceService(AnnounceDao announceDao){
        this.announceDao = announceDao;
    }
    
    
    public boolean registerAnnounce(AnnounceModel announce){
        AnnounceEntity announceEntity = new AnnounceEntity();
        announceEntity.setCategory(announce.getCategory());
        announceEntity.setDescription(announce.getDescription());
        announceEntity.setTitle(announce.getTitle());
        announceEntity.setId_user(announce.getUserId());
       
        try{
            announceDao.persist(announceEntity);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
