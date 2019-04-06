package mg.news.repositories;

import mg.news.dbentities.RadiotArticleDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RadiotArticleRepository extends CrudRepository<RadiotArticleDBEntity, Long> {

    Optional<RadiotArticleDBEntity> findTopByOrderByIdDesc();
}
