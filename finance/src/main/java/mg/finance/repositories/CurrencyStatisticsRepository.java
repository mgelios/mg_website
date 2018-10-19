package mg.finance.repositories;

import mg.finance.dbentities.CurrencyStatisticsDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyStatisticsRepository extends CrudRepository<CurrencyStatisticsDBEntity, Long> {
}
