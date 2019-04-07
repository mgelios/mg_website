package mg.news.repositories;

import mg.news.dbentities.RadiotPodcastDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiotPodcastRepository extends CrudRepository<RadiotPodcastDBEntity, Long> {
}
