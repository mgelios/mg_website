package mg.finance.utils;

import lombok.AllArgsConstructor;
import mg.finance.FinanceConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@EnableConfigurationProperties(FinanceConfiguration.class)
@AllArgsConstructor
public class CurrencyUrlBuilder{

    private static final String CURRENCY_CODE_NBRB_PARAM_MODE = "1";
    private static final String ABBREVIATION_NBRB_PARAM_MODE = "2";

    private final FinanceConfiguration financeConfiguration;

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

    public String buildCryptoCurrenciesUrl() {
        StringBuilder result = new StringBuilder();
        result.append("https://api.coinmarketcap.com/v1/ticker/?limit=100");
        return result.toString();
    }

    public String buildCryptoCurrenciesMarketUrl() {
        StringBuilder result = new StringBuilder();
        result.append("https://api.coinmarketcap.com/v1/global/");
        return result.toString();
    }
}
