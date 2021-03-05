package mg.finance.repository;

import mg.finance.entity.CurrencyConversion;
import mg.finance.entity.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CurrencyConversionRepository extends CrudRepository<CurrencyConversion, UUID> {

    void deleteAllByCurrencyFromAndAndCurrencyTo(Currency from, Currency to);

    List<CurrencyConversion> findAllByCurrencyFromAndCurrencyTo(Currency from, Currency to);

    Optional<CurrencyConversion> findByCurrencyFromAndCurrencyTo(Currency from, Currency to);
}
