package licenta.persistence.dao;

import java.util.List;

import licenta.persistence.entities.AnnounceEntity;

public interface AnnounceDao extends AbstractDao<AnnounceEntity>{

    List<AnnounceEntity> getAnnounceByUserId(String userName);
}
