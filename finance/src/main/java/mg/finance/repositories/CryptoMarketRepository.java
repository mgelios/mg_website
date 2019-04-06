package mg.finance.repositories;

import mg.finance.dbentities.CryptoMarketDBEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CryptoMarketRepository extends CrudRepository<CryptoMarketDBEntity, Long> {

    Optional<CryptoMarketDBEntity> findTopByOrderByIdDesc();
}
