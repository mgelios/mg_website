package mg.finance.services;

import mg.finance.FinanceConfiguration;
import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.models.Currency;
import mg.finance.models.CurrencyStatistics;
import mg.finance.repositories.CurrencyConversionRepository;
import mg.finance.repositories.CurrencyRepository;
import mg.finance.repositories.CurrencyStatisticsRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        jsonConsumer.getJson(currencyUrlBuilder.buildCurrencyRateUrl("USD"));
        CurrencyDBEntity dbEntity = new CurrencyDBEntity();
        return null;
    }
}
