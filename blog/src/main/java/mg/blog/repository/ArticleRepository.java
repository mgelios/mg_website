package mg.blog.repository;

import mg.blog.dbentity.ArticleDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<ArticleDBEntity, Long> {
}
