package mg.finance.repositories;

import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.dbentities.CurrencyStatisticsDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyStatisticsRepository extends CrudRepository<CurrencyStatisticsDBEntity, Long> {

    Optional<CurrencyStatisticsDBEntity> findFirstByCurrency(CurrencyDBEntity currencyDBEntity);

    List<CurrencyStatisticsDBEntity> findAllByCurrency(CurrencyDBEntity currencyDBEntity);

    void deleteAllByCurrency(CurrencyDBEntity currencyDBEntity);
}
