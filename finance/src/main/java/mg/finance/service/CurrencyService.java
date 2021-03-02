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
        Optional<Currency> optionalCurrency = currencyRepository.findByAbbreviation(abbreviation);
        Currency result = null;
        if (optionalCurrency.isPresent()) {
            result = optionalCurrency.get();
        }
        if (result == null || result.getDate().toLocalDateTime().getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
            result = updateCurrency(abbreviation);
        }
        return result;
    }

    public void updateDefaultCurrencies() {
        financeConfiguration.getDefaultCurrencies().forEach(this::updateCurrency);
    }

    public Currency updateCurrency(String abbreviation) {
        JSONObject json = jsonConsumer.getJsonObject(currencyUrlBuilder.buildCurrencyRateUrl(abbreviation));
        if (currencyRepository.findAllByAbbreviation(abbreviation).size() != 0) {
            currencyRepository.deleteAllByAbbreviation(abbreviation);
        }
        return saveCurrencyDBEntity(json);
    }

    public Currency saveCurrencyDBEntity(JSONObject json) {
        LocalDateTime exampleLocalDateTime = LocalDateTime.parse(jsonHelper.getString(json, "Date"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        OffsetDateTime exampleOffsetDateTime = OffsetDateTime.of(exampleLocalDateTime, ZoneOffset.ofHours(3));
        if (json != null) {
            Currency dbEntity = Currency.builder()
                    .systemId(jsonHelper.getInt(json, "Cur_ID"))
                    .date(OffsetDateTime.parse(
                            jsonHelper.getString(json, "Date").replace("T", " "),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .abbreviation(jsonHelper.getString(json, "Cur_Abbreviation"))
                    .scale(jsonHelper.getDouble(json, "Cur_Scale"))
                    .name(jsonHelper.getString(json, "Cur_Name"))
                    .rate(jsonHelper.getDouble(json, "Cur_OfficialRate"))
                    .build();
            return currencyRepository.save(dbEntity);
        } else {
            return null;
        }
    }
}
