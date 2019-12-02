package mg.news.repository;

import mg.news.entity.RadiotPodcastTimeLabel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiotPodcastTimeLabelRepository extends CrudRepository<RadiotPodcastTimeLabel, Long> {
}
