package mg.finance.repository;

import mg.finance.entity.CryptoMarket;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CryptoMarketRepository {// extends CrudRepository<CryptoMarket, UUID> {

    //Optional<CryptoMarket> findFirstByActiveCryptoCurrenciesIsNotNull();
}
