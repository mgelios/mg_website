package mg.finance.repositories;

import mg.finance.dbentities.CurrencyConversionDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionRepository extends CrudRepository<CurrencyConversionDBEntity, Long> {
}
