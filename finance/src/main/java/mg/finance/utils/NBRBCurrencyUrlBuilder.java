package mg.finance.utils;

import lombok.AllArgsConstructor;
import mg.finance.NBRBConfiguration;
import mg.utils.url.UrlBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
//@EnableConfigurationProperties(NBRBConfiguration.class)
@AllArgsConstructor
public class NBRBCurrencyUrlBuilder {

    private static final String CURRENCY_CODE_NBRB_PARAM_MODE = "1";
    private static final String ABBREVIATION_NBRB_PARAM_MODE = "2";

    private static final DateTimeFormatter NBRB_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d");

    private final NBRBConfiguration financeConfiguration;

    public String buildCurrencyRateUrl(String currency) {
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTP_PROTOCOL)
                .host(financeConfiguration.getHost())
                .addPathPart(financeConfiguration.getCurrencyPathPart())
                .addPathPart(currency)
                .addQueryParameter(financeConfiguration.getCurrencyUrlParamModeParameter(), ABBREVIATION_NBRB_PARAM_MODE)
                .build().getUrl();
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
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTP_PROTOCOL)
                .host(financeConfiguration.getHost())
                .addPathPart(financeConfiguration.getCurrencyPathPart())
                .addPathPart(financeConfiguration.getCurrencyStatisticsPathPart())
                .addPathPart(currencyId)
                .addQueryParameter(financeConfiguration.getCurrencyStatisticsStartDateParameter(), startDate)
                .addQueryParameter(financeConfiguration.getCurrencyStatisticsEndDateParameter(), endDate)
                .build().getUrl();
    }

}
