package mg.finance.utils;

import mg.finance.FinanceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasicCurrencyUrlBuilder implements CurrencyUrlBuilder{

    @Autowired
    FinanceConfiguration financeConfiguration;

    public String buildCurrencyRateUrl(String currency){
        StringBuilder result = new StringBuilder();
        result.append(financeConfiguration.getCurrencyBaseUrl())
                .append(financeConfiguration.getCurrencyRateSuffix())
                .append("USD")
                .append(financeConfiguration.getCurrencyUrlParamMode());
        return result.toString();
    }

}
