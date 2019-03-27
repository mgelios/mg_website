package mg.finance.utils;

import mg.finance.FinanceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@EnableConfigurationProperties(FinanceConfiguration.class)
public class BasicCurrencyUrlBuilder implements CurrencyUrlBuilder{

    @Autowired
    FinanceConfiguration financeConfiguration;

    public String buildCurrencyRateUrl(String currency) {
        StringBuilder result = new StringBuilder();
        result.append(financeConfiguration.getCurrencyBaseUrl())
                .append(financeConfiguration.getCurrencyRateSuffix())
                .append(currency)
                .append(financeConfiguration.getCurrencyUrlParamMode());
        return result.toString();
    }

    public String buildCurrencyStatisticsUrl(String currencyId) {
        StringBuilder result = new StringBuilder();
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minusDays(30);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        result.append(financeConfiguration.getCurrencyBaseUrl())
                .append(financeConfiguration.getCurrencyStatisticsSuffix())
                .append(currencyId)
                .append("?")
                .append("startDate=")
                .append(startDate.format(dateTimeFormatter))
                .append("&endDate=")
                .append(endDate.format(dateTimeFormatter));
        return result.toString();
    }

}
