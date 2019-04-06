package mg.finance.services;

import mg.finance.models.*;

import java.util.List;
import java.util.Map;

public interface CurrencyService {

    List<Currency> getDefaultCurrencyValues();

    Currency getCurrencyValue(String currency);

    List<CurrencyConversion> calculateDefaultCurrenciesConversions();

    CurrencyConversion calculateCurrenciesConversion(String from, String to);

    Map<String, List<CurrencyStatistics>> getDefaultCurrencyStatistics();

    List<CurrencyStatistics> getCurrencyStatistics(String currency);

    List<CryptoCurrency> getCryptoCurrenciesList();

    CryptoMarket getCryptoMarketInfo();
}
