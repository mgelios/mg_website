package mg.finance.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.finance.FinanceConfiguration;
import mg.finance.entity.CurrencyConversion;
import mg.finance.entity.Currency;
import mg.finance.repository.CurrencyConversionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CurrencyConversionService {

    private final FinanceConfiguration financeConfiguration;
    private final CurrencyService currencyService;
    private final CurrencyConversionRepository currencyConversionRepository;

    public List<CurrencyConversion> getDefaultCurrencyConversions() {
        return financeConfiguration.getDefaultConversionCombinations().stream()
                .map(conversionPair ->
                    getCurrencyConversion(conversionPair.split("[:]")[0], conversionPair.split("[:]")[1])
                )
                .collect(Collectors.toList());
    }

    public CurrencyConversion getCurrencyConversion(String abbreviationFrom, String abbreviationTo) {
        Currency from = currencyService.findCurrencyByAbbreviation(abbreviationFrom);
        Currency to = currencyService.findCurrencyByAbbreviation(abbreviationTo);
        if (from != null && to != null) {
            CurrencyConversion conversion = currencyConversionRepository
                    .findByCurrencyFromAndCurrencyTo(from, to)
                    .orElse(updateCurrencyConversion(from, to, null));
            if (conversion.getUpdatedOn().getDayOfYear() != from.getDate().getDayOfYear()) {
                conversion = updateCurrencyConversion(from, to, conversion);
            }
            return conversion;
        } else {
            return null;
        }
    }

    public CurrencyConversion updateCurrencyConversion(Currency from, Currency to, CurrencyConversion conversionToUpdate) {
        return saveCurrencyConversion(from, to, conversionToUpdate);
    }

    public CurrencyConversion saveCurrencyConversion(Currency from, Currency to, CurrencyConversion conversionToSave) {
        CurrencyConversion conversion = conversionToSave == null ? new CurrencyConversion() : conversionToSave;
        conversion.setCurrencyFrom(from);
        conversion.setCurrencyTo(to);
        conversion.setValue(getConversionValue(from, to));
        conversion.setUpdatedOn(from.getDate());
        return currencyConversionRepository.save(conversion);
    }

    private double getConversionValue(Currency from, Currency to) {
        double valueFrom = from.getRate() / from.getScale();
        double valueTo = to.getRate() / to.getScale();
        return valueFrom / valueTo;
    }
}
