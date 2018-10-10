package mg.profile.repositories;

import mg.profile.dbentities.UserDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserDBEntity, Long> {

    Optional<UserDBEntity> findByUsername(String username);

    Optional<UserDBEntity> findByEmail(String email);
}
