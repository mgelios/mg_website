package mg.news.repository;

import mg.news.entity.RadiotPodcast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiotPodcastRepository extends CrudRepository<RadiotPodcast, Long> {
}
