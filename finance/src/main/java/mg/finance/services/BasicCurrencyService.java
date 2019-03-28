package mg.finance.services;

import mg.finance.FinanceConfiguration;
import mg.finance.converters.CurrencyDBEntityToCurrency;
import mg.finance.converters.CurrencyStatisticsDBEntityToCurrencyStatistics;
import mg.finance.converters.CurrencyStatisticsToCurrencyStatisticsDBEntity;
import mg.finance.converters.CurrencyToCurrencyDBEntity;
import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.dbentities.CurrencyStatisticsDBEntity;
import mg.finance.models.CryptoCurrency;
import mg.finance.models.Currency;
import mg.finance.models.CurrencyConversion;
import mg.finance.models.CurrencyStatistics;
import mg.finance.repositories.CurrencyConversionRepository;
import mg.finance.repositories.CurrencyRepository;
import mg.finance.repositories.CurrencyStatisticsRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//TODO: separate cryptocurrency, currency, currency statistics processing
@Service
@EnableConfigurationProperties(FinanceConfiguration.class)
public class BasicCurrencyService implements CurrencyService {

    @Autowired
    FinanceConfiguration financeConfiguration;
    @Autowired
    CurrencyUrlBuilder currencyUrlBuilder;
    @Autowired
    JSONConsumer jsonConsumer;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    CurrencyStatisticsRepository currencyStatisticsRepository;
    @Autowired
    CurrencyConversionRepository currencyConversionRepository;
    @Autowired
    CurrencyDBEntityToCurrency currencyDBEntityToCurrency;
    @Autowired
    CurrencyToCurrencyDBEntity currencyToCurrencyDBEntity;
    @Autowired
    CurrencyStatisticsDBEntityToCurrencyStatistics currencyStatisticsDBEntityToCurrencyStatistics;
    @Autowired
    CurrencyStatisticsToCurrencyStatisticsDBEntity currencyStatisticsToCurrencyStatisticsDBEntity;

    @Override
    public List<Currency> getDefaultCurrencyValues() {
        return financeConfiguration.getDefaultCurrencies().stream()
                .map(currency -> getCurrencyValue(currency))
                .collect(Collectors.toList());
    }

    @Override
    public Currency getCurrencyValue(String currency) {
        CurrencyDBEntity dbEntity = null;
        if (currencyRepository.findByAbbreviation(currency).isPresent()) {
            dbEntity = currencyRepository.findByAbbreviation(currency).get();
            LocalDateTime dbTime = dbEntity.getDate().toLocalDateTime();
            if (dbTime.getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
                currencyRepository.delete(dbEntity);
                dbEntity = fillCurrencyDBEntity(currency);
            }
        } else {
            dbEntity = fillCurrencyDBEntity(currency);
        }
        return currencyDBEntityToCurrency.convert(dbEntity);
    }

    private CurrencyDBEntity fillCurrencyDBEntity(String currency) {
        CurrencyDBEntity dbEntity = new CurrencyDBEntity();
        JSONObject json = jsonConsumer.getJsonObject(currencyUrlBuilder.buildCurrencyRateUrl(currency));
        dbEntity.setSystemId(json.getInt("Cur_ID"));
        dbEntity.setDate(Timestamp.valueOf(json.getString("Date").replace("T", " ")));
        dbEntity.setAbbreviation(json.getString("Cur_Abbreviation"));
        dbEntity.setScale(json.getDouble("Cur_Scale"));
        dbEntity.setName(json.getString("Cur_Name"));
        dbEntity.setRate(json.getDouble("Cur_OfficialRate"));
        currencyRepository.save(dbEntity);
        return dbEntity;
    }

    @Override
    public List<CurrencyConversion> calculateCurrencyConversions() {
        return null;
    }

    @Override
    public Map<Currency, List<CurrencyStatistics>> getDefaultCurrencyStatistics() {
        getCurrencyStatistics(financeConfiguration.getDefaultStatisticsCurrencies().get(0));
        financeConfiguration.getDefaultStatisticsCurrencies().stream()
                .map(currency -> getCurrencyStatistics(currency)).collect(Collectors.toList());

        return null;
    }

    @Override
    public List<CurrencyStatistics> getCurrencyStatistics(String currency) {
        CurrencyDBEntity dbCurrency = currencyToCurrencyDBEntity.convert(getCurrencyValue(currency));
        List<CurrencyStatisticsDBEntity> dbStatisticsList = null;
        Optional<CurrencyStatisticsDBEntity> dbSingularStatistics = currencyStatisticsRepository.findFirstByCurrency(dbCurrency);
        if (dbSingularStatistics.isPresent()) {
            CurrencyStatisticsDBEntity dbStatistics = currencyStatisticsRepository.findFirstByCurrency(dbCurrency).get();
            LocalDateTime dbTime = dbStatistics.getDate().toLocalDateTime();
            if (dbTime.getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
                currencyStatisticsRepository.deleteAllByCurrency(dbCurrency);
                dbStatisticsList = fillCurrencyStatisticsDBEntity(dbCurrency);
            } else {
                dbStatisticsList = currencyStatisticsRepository.findAllByCurrency(dbCurrency);
            }
        } else {
            dbStatisticsList = fillCurrencyStatisticsDBEntity(dbCurrency);
        }
        return dbStatisticsList.stream()
                .map(currencyStatisticsDBEntityToCurrencyStatistics::convert)
                .collect(Collectors.toList());
    }

    private List<CurrencyStatisticsDBEntity> fillCurrencyStatisticsDBEntity(CurrencyDBEntity currencyDBEntity) {
        List<CurrencyStatisticsDBEntity> statistics = new ArrayList<>();
        JSONArray jsonArray = jsonConsumer.getJsonArray(currencyUrlBuilder.buildCurrencyStatisticsUrl(
                String.valueOf(currencyDBEntity.getSystemId())));
        for (Object item : jsonArray) {
            CurrencyStatisticsDBEntity statisticsDBEntity = new CurrencyStatisticsDBEntity();
            statisticsDBEntity.setDate(Timestamp.from(Instant.now()));
            statisticsDBEntity.setCurrency(currencyDBEntity);
            statisticsDBEntity.setRate(((JSONObject) item).getDouble("Cur_OfficialRate"));
            statisticsDBEntity.setId(((JSONObject) item).getLong("Cur_ID"));
            currencyStatisticsRepository.save(statisticsDBEntity);
            statistics.add(statisticsDBEntity);
        }
        return statistics;
    }

    @Override
    public List<CryptoCurrency> getCryptoCurrenciesList() {
        List<CryptoCurrency> result = new ArrayList<>();

        return result;
    }
}
