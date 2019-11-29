package mg.finance.repository;

import mg.finance.entity.CryptoCurrency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoCurrencyRepository extends CrudRepository<CryptoCurrency, Long> {

    Optional<CryptoCurrency> findTopByOrderByIdDesc();
}
