package mg.finance.repository;

import mg.finance.entity.CryptoMarket;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CryptoMarketRepository extends CrudRepository<CryptoMarket, Long> {

    Optional<CryptoMarket> findTopByOrderByIdDesc();
}
