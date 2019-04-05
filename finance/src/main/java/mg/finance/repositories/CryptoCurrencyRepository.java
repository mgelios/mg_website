package mg.finance.repositories;

import mg.finance.dbentities.CryptoCurrencyDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoCurrencyRepository extends CrudRepository<CryptoCurrencyDBEntity, Long> {

    Optional<CryptoCurrencyDBEntity> findTopByOrderByIdDesc();
}
