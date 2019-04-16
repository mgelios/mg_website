package mg.finance.services;

import mg.finance.FinanceConfiguration;
import mg.finance.converters.CurrencyStatisticsDTOToEntity;
import mg.finance.converters.CurrencyStatisticsEntityToDTO;
import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.dbentities.CurrencyStatisticsDBEntity;
import mg.finance.models.CurrencyStatistics;
import mg.finance.repositories.CurrencyStatisticsRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class CurrencyStatisticsService {

    @Autowired
    FinanceConfiguration financeConfiguration;
    @Autowired
    CurrencyUrlBuilder currencyUrlBuilder;
    @Autowired
    JSONConsumer jsonConsumer;
    @Autowired
    JSONHelper jsonHelper;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    CurrencyStatisticsRepository currencyStatisticsRepository;
    @Autowired
    CurrencyStatisticsDTOToEntity currencyStatisticsDTOToEntity;
    @Autowired
    CurrencyStatisticsEntityToDTO currencyStatisticsEntityToDTO;

    public Map<String, List<CurrencyStatistics>> getDefaultCurrencyStatistics() {
        return financeConfiguration.getDefaultStatisticsCurrencies().stream()
                .collect(Collectors.toMap(String::toString, this::getDefaultCurrencyStatisticsByAbbreviation));
    }

    public List<CurrencyStatistics> getDefaultCurrencyStatisticsByAbbreviation(String abbreviation) {
        CurrencyDBEntity currency = currencyService.getCurrencyDBEntityByAbbreviation(abbreviation);
        List<CurrencyStatisticsDBEntity> result = currencyStatisticsRepository.findAllByCurrency(currency);
        if (result.size() == 0 || result.get(0).getDate().toLocalDateTime().getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
            updateCurrencyStatistics(abbreviation);
            result = currencyStatisticsRepository.findAllByCurrency(currency);
        }
        return result.stream()
                .map(currencyStatisticsEntityToDTO::convert)
                .collect(Collectors.toList());
    }

    public void updateDefaultCurrencyStatistics() {
        financeConfiguration.getDefaultStatisticsCurrencies().forEach(this::updateCurrencyStatistics);
    }

    public void updateCurrencyStatistics(String abbreviation) {
        CurrencyDBEntity currency = currencyService.getCurrencyDBEntityByAbbreviation(abbreviation);
        JSONArray json = jsonConsumer.getJsonArray(currencyUrlBuilder.buildCurrencyStatisticsUrl(
                String.valueOf(currency.getSystemId())));
        if (currencyStatisticsRepository.findAllByCurrency(currency).size() > 0) {
            currencyStatisticsRepository.deleteAllByCurrency(currency);
        }
        saveCurrencyStatisticsDBEntities(json, currency);
    }

    private void saveCurrencyStatisticsDBEntities(JSONArray jsonArray, CurrencyDBEntity currency) {
        for (Object item : jsonArray) {
            CurrencyStatisticsDBEntity statisticsDBEntity = new CurrencyStatisticsDBEntity();
            statisticsDBEntity.setDate(Timestamp.from(Instant.now()));
            statisticsDBEntity.setCurrency(currency);
            statisticsDBEntity.setRate(((JSONObject) item).getDouble("Cur_OfficialRate"));
            statisticsDBEntity.setId(((JSONObject) item).getLong("Cur_ID"));
            currencyStatisticsRepository.save(statisticsDBEntity);
        }
    }
}
