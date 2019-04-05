package mg.finance.conrtollers;

import mg.finance.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/finance")
public class RestCurrenciesController {

    @Autowired
    CurrencyService currencyService;

    @RequestMapping("/currency/values")
    public Object getCurrencyValues() {
        return currencyService.getDefaultCurrencyValues();
    }

    @RequestMapping("/currency/statistics")
    public Object getCurrencyStatistics() {
        return currencyService.getDefaultCurrencyStatistics();
    }

    @RequestMapping("/currency/conversions")
    public Object getCurrencyConversions(){
        return currencyService.calculateDefaultCurrenciesConversions();
    }

    @RequestMapping("/crypto/currencies/list")
    public Object getCryptoCurrencies() {
        return currencyService.getCryptoCurrenciesList();
    }
}
