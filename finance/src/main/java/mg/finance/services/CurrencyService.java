package mg.finance.services;

import mg.finance.models.Currency;
import mg.finance.models.CurrencyConversion;
import mg.finance.models.CurrencyStatistics;

import java.util.List;

public interface CurrencyService {

    Currency getCurrencyValues();

    List<CurrencyConversion> calculateCurrencyConversions();

    List<CurrencyStatistics> getCurrencyStatistics();
}
