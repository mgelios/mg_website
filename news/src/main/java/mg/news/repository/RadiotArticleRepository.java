package mg.news.repository;

import mg.news.entity.RadiotArticle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RadiotArticleRepository extends CrudRepository<RadiotArticle, UUID> {

    Optional<RadiotArticle> findTopByOrderByOriginalTimeDesc();
}
