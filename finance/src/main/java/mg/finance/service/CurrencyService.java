package mg.finance.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.finance.FinanceConfiguration;
import mg.finance.entity.Currency;
import mg.finance.repository.CurrencyRepository;
import mg.utils.JSONHelper;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
                .map(this::getCurrencyByAbbreviation)
                .collect(Collectors.toList());
    }

    public Currency getCurrencyByAbbreviation(String abbreviation) {
        Currency result = currencyRepository.findByAbbreviation(abbreviation)
                .orElse(updateCurrency(abbreviation, null));

        if (isCurrencyDataRelevant(result)) {
            result = updateCurrency(abbreviation, result);
        }
        return result;
    }

    public Currency findCurrencyByAbbreviation(String abbreviation) {
        return currencyRepository.findByAbbreviation(abbreviation).orElse(null);
    }

    public boolean isCurrencyDataRelevant(Currency currency) {
        return currency.getDate().getDayOfYear() != OffsetDateTime.now().getDayOfYear();
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
            return null;
        }
    }
}
