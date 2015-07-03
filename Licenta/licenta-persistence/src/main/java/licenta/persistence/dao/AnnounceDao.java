package licenta.persistence.dao;

import java.util.List;

import licenta.persistence.entities.AnnounceEntity;
import ro.licenta.customer.models.AnnounceDetailsComplexResponse;

public interface AnnounceDao extends AbstractDao<AnnounceEntity>{

    List<AnnounceEntity> getAnnounceByUserId(String userName);

    List<AnnounceEntity> getAllAnnounces();

    AnnounceDetailsComplexResponse getAnnounceByAnnounceId(long announceId);

    List<AnnounceEntity> getAnnounceByCategory(String category);
}
