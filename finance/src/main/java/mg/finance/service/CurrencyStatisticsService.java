package mg.finance.service;

import lombok.AllArgsConstructor;
import mg.finance.FinanceConfiguration;
import mg.finance.entity.Currency;
import mg.finance.entity.CurrencyStatistics;
import mg.finance.repository.CurrencyStatisticsRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.postgresql.util.PSQLException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CurrencyStatisticsService {

    private final FinanceConfiguration financeConfiguration;
    private final CurrencyUrlBuilder currencyUrlBuilder;
    private final JSONConsumer jsonConsumer;
    private final JSONHelper jsonHelper;
    private final CurrencyService currencyService;
    private final CurrencyStatisticsRepository currencyStatisticsRepository;

    public Map<String, List<CurrencyStatistics>> getDefaultCurrencyStatistics() {
        return financeConfiguration.getDefaultStatisticsCurrencies().stream()
                .collect(Collectors.toMap(String::toString, this::getDefaultCurrencyStatisticsByAbbreviation));
    }

    public List<CurrencyStatistics> getDefaultCurrencyStatisticsByAbbreviation(String abbreviation) {
        Currency currency = currencyService.getCurrencyByAbbreviation(abbreviation);
        List<CurrencyStatistics> result = currencyStatisticsRepository.findAllByCurrency(currency);
        if (result.size() == 0 || result.get(0).getDate().getDayOfYear() != currency.getDate().getDayOfYear()) {
            result = updateCurrencyStatistics(currency);
        }
        return result;
    }

    public List<CurrencyStatistics> updateCurrencyStatistics(Currency currency) {
        JSONArray json = jsonConsumer.getJsonArray(currencyUrlBuilder.buildCurrency30DaysStatisticsUrl(
                String.valueOf(currency.getSystemId())));
        if (currencyStatisticsRepository.findAllByCurrency(currency).size() > 0) {
            currencyStatisticsRepository.deleteAllByCurrency(currency);
        }
        return saveCurrencyStatistics(json, currency);
    }

    private List<CurrencyStatistics> saveCurrencyStatistics(JSONArray jsonArray, Currency currency) {
        if (jsonArray != null) {
            List<CurrencyStatistics> result = new ArrayList<>();
            for (Object item : jsonArray) {
                JSONObject jsonItem = (JSONObject) item;
                CurrencyStatistics statisticsDBEntity = CurrencyStatistics.builder()
                        .date(jsonHelper.getOffsetDateTime(jsonItem, "Date",
                                DateTimeFormatter.ISO_LOCAL_DATE_TIME, ZoneOffset.ofHours(3)))
                        .currency(currency)
                        .rate(jsonHelper.getDouble(jsonItem, "Cur_OfficialRate"))
                        .currencyId(jsonHelper.getLong(jsonItem, "Cur_ID"))
                        .build();
                result.add(currencyStatisticsRepository.save(statisticsDBEntity));
            }
            return result;
        } else {
            return null;
        }
    }
}
