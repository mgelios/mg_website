package mg.news.repositories;

import mg.news.dbentities.RadiotPodcastTimeLabelDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiotPodcastTimeLabelRepository extends CrudRepository<RadiotPodcastTimeLabelDBEntity, Long> {
}
