package mg.common.repositories;

import mg.common.dbentities.RoleDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<RoleDBEntity, Long> {

    Optional<RoleDBEntity> findByName(String name);
}
