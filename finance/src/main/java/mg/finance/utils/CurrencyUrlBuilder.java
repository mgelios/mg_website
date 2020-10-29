package mg.finance.utils;

import lombok.AllArgsConstructor;
import mg.finance.FinanceConfiguration;
import mg.utils.url.UrlBuilder;
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

    private static final DateTimeFormatter NBRB_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d");

    private final FinanceConfiguration financeConfiguration;

    public String buildCurrencyRateUrl(String currency) {
        String result = (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTP_PROTOCOL)
                .host(financeConfiguration.getCurrencyBaseUrl())
                .addPathPart(currency)
                .addQueryParameter(financeConfiguration.getCurrencyUrlParamModeParameter(), ABBREVIATION_NBRB_PARAM_MODE)
                .build().getUrl();
        return result;
    }

    public String buildCurrency30DaysStatisticsUrl(String currencyId) {
        return buildCurrencyStatisticsForLastDaysUrl(currencyId, 30);
    }

    public String buildCurrency365DaysStatisticsUrl(String currencyId) {
        return buildCurrencyStatisticsForLastDaysUrl(currencyId, 365);
    }

    public String buildCurrencyStatisticsForLastDaysUrl(String currencyId, long days) {
        String endDate = LocalDateTime.now()
                .format(NBRB_DATETIME_FORMATTER);
        String startDate = LocalDateTime.now()
                .minusDays(days)
                .format(NBRB_DATETIME_FORMATTER);
        String result = (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTP_PROTOCOL)
                .host(financeConfiguration.getCurrencyBaseUrl())
                .addPathPart(financeConfiguration.getCurrencyStatisticsPathPart())
                .addPathPart(currencyId)
                .addQueryParameter(financeConfiguration.getCurrencyStatisticsStartDateParameter(), startDate)
                .addQueryParameter(financeConfiguration.getCurrencyStatisticsEndDateParameter(), endDate)
                .build().getUrl();
        return result;
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
