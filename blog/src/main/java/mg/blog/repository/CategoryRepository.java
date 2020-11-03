package mg.blog.repository;

import mg.blog.entity.CategoryDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryDBEntity, Long> {

    List<CategoryDBEntity> findAll();
}
