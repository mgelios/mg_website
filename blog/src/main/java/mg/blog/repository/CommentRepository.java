package mg.blog.repository;

import mg.blog.entity.CommentDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentDBEntity, Long> {
}
