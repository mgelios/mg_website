package mg.finance.repositories;

import mg.finance.dbentities.CurrencyDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyDBEntity, Long> {

    Optional<CurrencyDBEntity> findByAbbreviation(String abbreviation);
}
