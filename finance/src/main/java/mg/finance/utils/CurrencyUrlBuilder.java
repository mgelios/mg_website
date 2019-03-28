package mg.finance.utils;

public interface CurrencyUrlBuilder {

    String buildCurrencyRateUrl(String currency);

    String buildCurrencyStatisticsUrl(String currencyId);

    String buildCryptoCurrenciesUrl();

    String buildCryptoCurrenciesMarketUrl();
}
