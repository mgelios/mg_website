package mg.finance.services;

import mg.finance.models.CryptoCurrency;
import mg.finance.models.Currency;
import mg.finance.models.CurrencyConversion;
import mg.finance.models.CurrencyStatistics;

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
}
