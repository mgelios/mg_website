package mg.finance.service;

import lombok.AllArgsConstructor;
import mg.finance.FinanceConfiguration;
import mg.finance.entity.Currency;
import mg.finance.entity.CurrencyStatistics;
import mg.finance.mapper.CurrencyStatisticsMapper;
import mg.finance.dto.CurrencyStatisticsDto;
import mg.finance.repository.CurrencyStatisticsRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CurrencyStatisticsService {

    private final FinanceConfiguration financeConfiguration;
    private final CurrencyUrlBuilder currencyUrlBuilder;
    private final JSONConsumer jsonConsumer;
    private final JSONHelper jsonHelper;
    private final CurrencyService currencyService;
    private final CurrencyStatisticsRepository currencyStatisticsRepository;
    private final CurrencyStatisticsMapper currencyStatisticsMapper;

    public Map<String, List<CurrencyStatisticsDto>> getDefaultCurrencyStatistics() {
        return financeConfiguration.getDefaultStatisticsCurrencies().stream()
                .collect(Collectors.toMap(String::toString, this::getDefaultCurrencyStatisticsByAbbreviation));
    }

    public List<CurrencyStatisticsDto> getDefaultCurrencyStatisticsByAbbreviation(String abbreviation) {
        Currency currency = currencyService.getCurrencyDBEntityByAbbreviation(abbreviation);
        List<CurrencyStatistics> result = currencyStatisticsRepository.findAllByCurrency(currency);
        if (result.size() == 0 || result.get(0).getDate().toLocalDateTime().getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
            result = updateCurrencyStatistics(abbreviation);
        }
        return result.stream()
                .map(currencyStatisticsMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public void updateDefaultCurrencyStatistics() {
        financeConfiguration.getDefaultStatisticsCurrencies().forEach(this::updateCurrencyStatistics);
    }

    public List<CurrencyStatistics> updateCurrencyStatistics(String abbreviation) {
        Currency currency = currencyService.getCurrencyDBEntityByAbbreviation(abbreviation);
        JSONArray json = jsonConsumer.getJsonArray(currencyUrlBuilder.buildCurrency30DaysStatisticsUrl(
                String.valueOf(currency.getSystemId())));
        if (currencyStatisticsRepository.findAllByCurrency(currency).size() > 0) {
            currencyStatisticsRepository.deleteAllByCurrency(currency);
        }
        return saveCurrencyStatisticsDBEntities(json, currency);
    }

    private List<CurrencyStatistics> saveCurrencyStatisticsDBEntities(JSONArray jsonArray, Currency currency) {
        if (jsonArray != null) {
            List<CurrencyStatistics> result = new ArrayList<>();
            for (Object item : jsonArray) {
                JSONObject jsonItem = (JSONObject) item;
                CurrencyStatistics statisticsDBEntity = CurrencyStatistics.builder()
                        .date(jsonHelper.getTimestampFromFormat(jsonItem, "Date", "yyyy-MM-dd'T'HH:mm:ss"))
                        .currency(currency)
                        .rate(jsonHelper.getDouble(jsonItem, "Cur_OfficialRate"))
                        .id(jsonHelper.getLong(jsonItem, "Cur_ID"))
                        .build();
                result.add(currencyStatisticsRepository.save(statisticsDBEntity));
            }
            return result;
        } else {
            return null;
        }
    }
}
