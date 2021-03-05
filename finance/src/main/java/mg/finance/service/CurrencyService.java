package mg.finance.service;

import lombok.AllArgsConstructor;
import mg.finance.FinanceConfiguration;
import mg.finance.entity.Currency;
import mg.finance.mapper.CurrencyMapper;
import mg.finance.dto.CurrencyDto;
import mg.finance.repository.CurrencyRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CurrencyService {

    private final FinanceConfiguration financeConfiguration;
    private final CurrencyUrlBuilder currencyUrlBuilder;
    private final JSONConsumer jsonConsumer;
    private final JSONHelper jsonHelper;
    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    public List<CurrencyDto> getDefaultCurrencies() {
        return financeConfiguration.getDefaultCurrencies().stream()
                .map(this::getCurrencyByAbbreviation)
                .collect(Collectors.toList());
    }

    public CurrencyDto getCurrencyByAbbreviation(String abbreviation) {
        return currencyMapper.mapToDTO(getCurrencyDBEntityByAbbreviation(abbreviation));
    }

    public Currency getCurrencyDBEntityByAbbreviation(String abbreviation) {
        Currency result = currencyRepository.findByAbbreviation(abbreviation)
                .orElse(updateCurrency(abbreviation, null));

        if (result.getDate().getDayOfYear() != OffsetDateTime.now().getDayOfYear()) {
            result = updateCurrency(abbreviation, result);
        }
        return result;
    }

    //TODO: probably json fetching should go to specific service, not one with db interactions
    public Currency updateCurrency(String abbreviation, Currency entityToUpdate) {
        JSONObject json = jsonConsumer.getJsonObject(currencyUrlBuilder.buildCurrencyRateUrl(abbreviation));
        return json != null ? saveCurrencyDBEntity(json, entityToUpdate) : null;
    }

    public Currency saveCurrencyDBEntity(JSONObject json, Currency entityToUpdate) {
        Currency dbEntity = entityToUpdate == null ? new Currency() : entityToUpdate;
        dbEntity.setSystemId(jsonHelper.getInt(json, "Cur_ID"));
        dbEntity.setDate(jsonHelper.getOffsetDateTime(json, "Date",
                        DateTimeFormatter.ISO_LOCAL_DATE_TIME, ZoneOffset.ofHours(3)));
        dbEntity.setAbbreviation(jsonHelper.getString(json, "Cur_Abbreviation"));
        dbEntity.setScale(jsonHelper.getDouble(json, "Cur_Scale"));
        dbEntity.setName(jsonHelper.getString(json, "Cur_Name"));
        dbEntity.setRate(jsonHelper.getDouble(json, "Cur_OfficialRate"));
        return currencyRepository.save(dbEntity);
    }
}
