package mg.finance.repository;

import mg.finance.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, UUID> {

    Optional<Currency> findCurrencyByAbbreviation(String abbreviation);

    void deleteAllByAbbreviation(String abbreviation);
}