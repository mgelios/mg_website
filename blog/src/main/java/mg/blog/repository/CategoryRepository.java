package mg.blog.repository;

import mg.blog.dbentity.CategoryDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryDBEntity, Long> {
}
