package mg.news.repositories;

import mg.news.dbentities.RadiotArticleDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiotArticleRepository extends CrudRepository<RadiotArticleDBEntity, Long> {
}
