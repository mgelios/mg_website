package mg.finance.services;

import mg.finance.FinanceConfiguration;
import mg.finance.converters.*;
import mg.finance.dbentities.CryptoCurrencyDBEntity;
import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.dbentities.CurrencyStatisticsDBEntity;
import mg.finance.models.*;
import mg.finance.models.Currency;
import mg.finance.repositories.CryptoCurrencyRepository;
import mg.finance.repositories.CurrencyConversionRepository;
import mg.finance.repositories.CurrencyRepository;
import mg.finance.repositories.CurrencyStatisticsRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
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
    JSONHelper jsonHelper;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    CurrencyStatisticsRepository currencyStatisticsRepository;
    @Autowired
    CurrencyConversionRepository currencyConversionRepository;
    @Autowired
    CryptoCurrencyRepository cryptoCurrencyRepository;
    @Autowired
    CurrencyDBEntityToCurrency currencyDBEntityToCurrency;
    @Autowired
    CurrencyToCurrencyDBEntity currencyToCurrencyDBEntity;
    @Autowired
    CurrencyConversionDBEntityToCurrencyConversion currencyConversionDBEntityToCurrencyConversion;
    @Autowired
    CurrencyConversionToCurrencyConversionDBEntity currencyConversionToCurrencyConversionDBEntity;
    @Autowired
    CurrencyStatisticsDBEntityToCurrencyStatistics currencyStatisticsDBEntityToCurrencyStatistics;
    @Autowired
    CurrencyStatisticsToCurrencyStatisticsDBEntity currencyStatisticsToCurrencyStatisticsDBEntity;
    @Autowired
    CryptoCurrencyDBEntityToCryptoCurrency cryptoCurrencyDBEntityToCryptoCurrency;
    @Autowired
    CryptoCurrencyToCryptoCurrencyDBEntity cryptoCurrencyToCryptoCurrencyDBEntity;

    public List<Currency> getDefaultCurrencyValues() {
        return financeConfiguration.getDefaultCurrencies().stream()
                .map(currency -> getCurrencyValue(currency))
                .collect(Collectors.toList());
    }

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

    public List<CurrencyConversion> calculateDefaultCurrenciesConversions() {
        return financeConfiguration.getDefaultConversionCombinations()
                .stream()
                .map(conversionPair -> {
                    return calculateCurrenciesConversion(conversionPair.split("[:]")[0], conversionPair.split("[:]")[1]);
                })
                .collect(Collectors.toList());
    }

    public CurrencyConversion calculateCurrenciesConversion(String from, String to) {
        Currency currencyFrom = getCurrencyValue(from);
        Currency currencyTo = getCurrencyValue(to);
        currencyConversionRepository.deleteAll();
        CurrencyConversion currencyConversion = new CurrencyConversion();
        currencyConversion.setValue((currencyFrom.getRate() / currencyFrom.getScale())/(currencyTo.getRate() / currencyTo.getScale()));
        currencyConversion.setCurrencyFrom(currencyFrom);
        currencyConversion.setCurrencyTo(currencyTo);
        currencyConversionRepository.save(currencyConversionToCurrencyConversionDBEntity.convert(currencyConversion));
        return currencyConversion;
    }

    public Map<String, List<CurrencyStatistics>> getDefaultCurrencyStatistics() {
        return financeConfiguration.getDefaultStatisticsCurrencies().stream()
                .collect(Collectors.toMap(String::toString, this::getCurrencyStatistics));
    }

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

    public List<CryptoCurrency> getCryptoCurrenciesList() {
        List<CryptoCurrencyDBEntity> result = new ArrayList<>();
        Optional<CryptoCurrencyDBEntity> optionalCryptoCurrency = cryptoCurrencyRepository.findTopByOrderByIdDesc();
        if (optionalCryptoCurrency.isPresent()) {
            CryptoCurrencyDBEntity singularCryptoCurrency = optionalCryptoCurrency.get();
            if (singularCryptoCurrency.getLastUpdated().toLocalDateTime().getMinute() != LocalDateTime.now().getMinute()) {
                cryptoCurrencyRepository.deleteAll();
                result = fillCryptoCurrencyDBEntity();
            } else {
                cryptoCurrencyRepository.findAll().forEach(result::add);
            }
        } else {
            result = fillCryptoCurrencyDBEntity();
        }
        return result.stream()
                .map(cryptoCurrencyDBEntityToCryptoCurrency::convert)
                .collect(Collectors.toList());
    }

    private List<CryptoCurrencyDBEntity> fillCryptoCurrencyDBEntity(){
        List<CryptoCurrencyDBEntity> cryptoCurrenciesList = new ArrayList<>();
        JSONArray jsonArray = jsonConsumer.getJsonArray(currencyUrlBuilder.buildCryptoCurrenciesUrl());
        for (Object item : jsonArray) {
            Double maxSupply = ((JSONObject) item).get("max_supply").getClass() == JSONObject.NULL.getClass() ? 0 : ((JSONObject) item).getDouble("max_supply");
            CryptoCurrencyDBEntity cryptoCurrencyDBEntity = new CryptoCurrencyDBEntity();
            cryptoCurrencyDBEntity.setName(((JSONObject) item).getString("name"));
            cryptoCurrencyDBEntity.setSymbol(((JSONObject) item).getString("symbol"));
            cryptoCurrencyDBEntity.setRank(((JSONObject) item).getLong("rank"));
            cryptoCurrencyDBEntity.setPriceUSD(((JSONObject) item).getDouble("price_usd"));
            cryptoCurrencyDBEntity.setPriceBTC(((JSONObject) item).getDouble("price_btc"));
            cryptoCurrencyDBEntity.setVolumeUSD24h(((JSONObject) item).getDouble("24h_volume_usd"));
            cryptoCurrencyDBEntity.setMarketCapUSD(((JSONObject) item).getDouble("market_cap_usd"));
            cryptoCurrencyDBEntity.setAvailableSupply(((JSONObject) item).getDouble("available_supply"));
            cryptoCurrencyDBEntity.setTotalSupply(((JSONObject) item).getDouble("total_supply"));
            cryptoCurrencyDBEntity.setMaxSupply(maxSupply);
            cryptoCurrencyDBEntity.setPercentChangeIn1h(((JSONObject) item).getDouble("percent_change_1h"));
            cryptoCurrencyDBEntity.setPercentChangeIn24h(((JSONObject) item).getDouble("percent_change_24h"));
            cryptoCurrencyDBEntity.setPercentChangeIn7d(((JSONObject) item).getDouble("percent_change_7d"));
            cryptoCurrencyDBEntity.setLastUpdated(jsonHelper.getTimestampOfEpochSecond((JSONObject) item, "last_updated"));
            cryptoCurrencyDBEntity = cryptoCurrencyRepository.save(cryptoCurrencyDBEntity);
            cryptoCurrenciesList.add(cryptoCurrencyDBEntity);
        }
        return cryptoCurrenciesList;
    }

    public CryptoMarket getCryptoMarketInfo() {
        return null;
    }
}
