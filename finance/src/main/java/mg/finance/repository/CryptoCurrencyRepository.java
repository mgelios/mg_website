package mg.finance.repository;

import mg.finance.entity.CryptoCurrency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

//@Repository
public interface CryptoCurrencyRepository {//} extends CrudRepository<CryptoCurrency, UUID> {

    //Optional<CryptoCurrency> findFirstByMarketCapUsdNotNull();
}
