package mg.finance.service.currency;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.finance.FinanceConfiguration;
import mg.finance.entity.Currency;
import mg.finance.repository.CurrencyRepository;
import mg.utils.JSONHelper;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CurrencyService {

    private final FinanceConfiguration financeConfiguration;
    private final CurrencyRepository currencyRepository;
    private final CurrencyExternalApiService currencyExternalApiService;
    private final JSONHelper jsonHelper;

    public List<Currency> getDefaultCurrencies() {
        return financeConfiguration.getDefaultCurrencies().stream()
                .map(this::findCurrencyByAbbreviation)
                .collect(Collectors.toList());
    }

    public synchronized Currency findCurrencyByAbbreviation(String abbreviation) {
        Optional<Currency> currency = currencyRepository.findCurrencyByAbbreviation(abbreviation);

        if (!currency.isPresent() || !isCurrencyDataRelevant(currency.get())) {
            return updateCurrency(abbreviation, currency.orElse(null));
        }
        return currency.get();
    }

    public boolean isCurrencyDataRelevant(Currency currency) {
        return currency.getDate().getDayOfYear() == OffsetDateTime.now().getDayOfYear();
    }

    @Transactional
    public Currency updateCurrency(String abbreviation, Currency entityToUpdate) {
        return saveCurrencyDBEntity(currencyExternalApiService.fetchCurrencyRate(abbreviation), entityToUpdate);
    }

    public Currency saveCurrencyDBEntity(JSONObject json, Currency entityToSave) {
        if (json != null) {
            Currency currency = entityToSave == null ? new Currency() : entityToSave;
            currency.setSystemId(jsonHelper.getInt(json, "Cur_ID"));
            currency.setDate(jsonHelper.getOffsetDateTime(json, "Date",
                    DateTimeFormatter.ISO_LOCAL_DATE_TIME, ZoneOffset.ofHours(3)));
            currency.setAbbreviation(jsonHelper.getString(json, "Cur_Abbreviation"));
            currency.setScale(jsonHelper.getDouble(json, "Cur_Scale"));
            currency.setName(jsonHelper.getString(json, "Cur_Name"));
            currency.setRate(jsonHelper.getDouble(json, "Cur_OfficialRate"));
            return currencyRepository.save(currency);
        } else {
            return entityToSave;
        }
    }
}
