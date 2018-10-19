package mg.finance.repositories;

import mg.finance.dbentities.CurrencyDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyDBEntity, Long> {
}
