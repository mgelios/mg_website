package mg.finance.services;

import mg.finance.FinanceConfiguration;
import mg.finance.converters.CurrencyDBEntityToCurrency;
import mg.finance.converters.CurrencyToCurrencyDBEntity;
import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.models.Currency;
import mg.finance.models.CurrencyConversion;
import mg.finance.models.CurrencyStatistics;
import mg.finance.repositories.CurrencyConversionRepository;
import mg.finance.repositories.CurrencyRepository;
import mg.finance.repositories.CurrencyStatisticsRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
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

    @Override
    public Currency getCurrencyValues() {
        CurrencyDBEntity dbEntity = currencyRepository.findByAbbreviation("USD").get();
        if (dbEntity != null){
            LocalDateTime dbTime = LocalDateTime.from(dbEntity.getDate().toInstant());
            if (dbTime.getDayOfYear() != LocalDateTime.now().getDayOfYear()){
                currencyRepository.delete(dbEntity);
                dbEntity = fillCurrencyDBEntity();
            }
        } else {
            dbEntity = fillCurrencyDBEntity();
        }
        return currencyDBEntityToCurrency.convert(dbEntity);
    }

    private CurrencyDBEntity fillCurrencyDBEntity(){
        CurrencyDBEntity dbEntity = new CurrencyDBEntity();
        JSONObject json = jsonConsumer.getJson(currencyUrlBuilder.buildCurrencyRateUrl("USD"));
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
    public List<CurrencyStatistics> getCurrencyStatistics() {
        CurrencyDBEntity dbCurrency = currencyRepository.findByAbbreviation("USD").get();
        if (currencyStatisticsRepository.findFirstByCurrency(dbCurrency).isPresent()){

        }
        return null;
    }
}
