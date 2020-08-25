package mg.finance.repository;

import mg.finance.entity.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    Optional<Currency> findByAbbreviation(String abbreviation);

    List<Currency> findAllByAbbreviation(String abbreviation);

    void deleteAllByAbbreviation(String abbreviation);
}