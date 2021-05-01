package mg.news.repository;

import mg.news.entity.RadiotPodcast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RadiotPodcastRepository extends CrudRepository<RadiotPodcast, UUID> {

    List<RadiotPodcast> findAll();
}
