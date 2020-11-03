package mg.blog.repository;

import mg.blog.entity.TagDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<TagDBEntity, Long> {
}
