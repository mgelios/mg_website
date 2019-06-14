package mg.blog.repository;

import mg.blog.dbentity.SubcategoryDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends CrudRepository<SubcategoryDBEntity, Long> {
}
