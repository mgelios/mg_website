package mg.news.repository;

import mg.news.entity.RadiotArticle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RadiotArticleRepository extends CrudRepository<RadiotArticle, Long> {

    Optional<RadiotArticle> findTopByOrderByIdDesc();
}
