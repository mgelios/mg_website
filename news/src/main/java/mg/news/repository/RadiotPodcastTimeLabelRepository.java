package mg.news.repository;

import mg.news.entity.RadiotPodcastTimeLabel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RadiotPodcastTimeLabelRepository extends CrudRepository<RadiotPodcastTimeLabel, UUID> {
}
