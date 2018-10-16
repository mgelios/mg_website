package mg.finance.services;

import mg.finance.FinanceConfiguration;
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

    @Override
    public String getCurrencyValues() {
        jsonConsumer.getJson(currencyUrlBuilder.buildCurrencyRateUrl("USD"));
        return jsonConsumer.toString();
    }
}
