package mg.finance.services;

import mg.finance.FinanceConfiguration;
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

    @Override
    public Currency getCurrencyValues() {
        JSONObject json = jsonConsumer.getJson(currencyUrlBuilder.buildCurrencyRateUrl("USD"));
        CurrencyDBEntity dbEntity = new CurrencyDBEntity();
        dbEntity.setSystemId(json.getInt("Cur_ID"));
        dbEntity.setDate(Timestamp.valueOf(json.getString("Date").replace("T", " ")));
        dbEntity.setRate(json.getDouble("Cur_OfficialRate"));
        dbEntity.setAbbreviation(json.getString("Cur_Abbreviation"));
        dbEntity.setScale(json.getDouble("Cur_Scale"));
        return null;
    }

    @Override
    public List<CurrencyConversion> calculateCurrencyConversions() {
        return null;
    }

    @Override
    public List<CurrencyStatistics> getCurrencyStatistics() {
        return null;
    }
}
