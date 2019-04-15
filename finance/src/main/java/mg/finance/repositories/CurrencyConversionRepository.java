package mg.finance.repositories;

import mg.finance.dbentities.CurrencyConversionDBEntity;
import mg.finance.dbentities.CurrencyDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyConversionRepository extends CrudRepository<CurrencyConversionDBEntity, Long> {

    void deleteAllByCurrencyFromAndAndCurrencyTo(CurrencyDBEntity from, CurrencyDBEntity to);

    List<CurrencyConversionDBEntity> findAllByCurrencyFromAndCurrencyTo(CurrencyDBEntity from, CurrencyDBEntity to);

    Optional<CurrencyConversionDBEntity> findByCurrencyFromAndCurrencyTo(CurrencyDBEntity from, CurrencyDBEntity to);
}
