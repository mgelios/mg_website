package mg.finance.service;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class CurrencyStatisticsService {

    @Autowired
    private FinanceConfiguration financeConfiguration;
    @Autowired
    private CurrencyUrlBuilder currencyUrlBuilder;
    @Autowired
    private JSONConsumer jsonConsumer;
    @Autowired
    private JSONHelper jsonHelper;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private CurrencyStatisticsRepository currencyStatisticsRepository;

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
                .map(CurrencyStatisticsMapper.INSTANCE::mapToDTO)
                .collect(Collectors.toList());
    }

    public void updateDefaultCurrencyStatistics() {
        financeConfiguration.getDefaultStatisticsCurrencies().forEach(this::updateCurrencyStatistics);
    }

    public List<CurrencyStatistics> updateCurrencyStatistics(String abbreviation) {
        Currency currency = currencyService.getCurrencyDBEntityByAbbreviation(abbreviation);
        JSONArray json = jsonConsumer.getJsonArray(currencyUrlBuilder.buildCurrencyStatisticsUrl(
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
                CurrencyStatistics statisticsDBEntity = new CurrencyStatistics();
                JSONObject jsonItem = (JSONObject) item;
                statisticsDBEntity.setDate(jsonHelper.getTimestampFromFormat(jsonItem, "Date", "yyyy-MM-dd'T'HH:mm:ss"));
                statisticsDBEntity.setCurrency(currency);
                statisticsDBEntity.setRate(jsonHelper.getDouble(jsonItem, "Cur_OfficialRate"));
                statisticsDBEntity.setId(jsonHelper.getLong(jsonItem, "Cur_ID"));
                result.add(currencyStatisticsRepository.save(statisticsDBEntity));
            }
            return result;
        } else {
            return null;
        }
    }
}
