package mg.finance.repository;

import mg.finance.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.UUID;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, UUID> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query(value = "select c from Currency c where c.abbreviation=:abbreviation")
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "1000")})
    Currency findCurrencyByAbbreviation(String abbreviation);

    void deleteAllByAbbreviation(String abbreviation);
}