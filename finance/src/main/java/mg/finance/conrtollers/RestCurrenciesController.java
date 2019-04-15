package mg.finance.conrtollers;

import mg.finance.services.CurrencyService;
import mg.finance.services.ImprovedCurrencyConversionService;
import mg.finance.services.ImprovedCurrencyService;
import mg.finance.services.ImprovedCurrencyStatisticsService;
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
    @Autowired
    ImprovedCurrencyService improvedCurrencyService;
    @Autowired
    ImprovedCurrencyStatisticsService improvedCurrencyStatisticsService;
    @Autowired
    ImprovedCurrencyConversionService improvedCurrencyConversionService;

    @RequestMapping("/currency/values")
    public Object getCurrencyValues() {
        //return currencyService.getDefaultCurrencyValues();
        return improvedCurrencyService.getDefaultCurrencies();
    }

    @RequestMapping("/currency/statistics")
    public Object getCurrencyStatistics() {
        //return currencyService.getDefaultCurrencyStatistics();
        return improvedCurrencyStatisticsService.getDefaultCurrencyStatistics();
    }

    @RequestMapping("/currency/conversions")
    public Object getCurrencyConversions(){
        //return currencyService.calculateDefaultCurrenciesConversions();
        return improvedCurrencyConversionService.getDefaultCurrencyConversions();
    }

    @RequestMapping("/crypto/currencies/list")
    public Object getCryptoCurrencies() {
        return currencyService.getCryptoCurrenciesList();
    }

    @RequestMapping("/crypto/market")
    public Object getCryptoMarketInfo() {
        return currencyService.getCryptoMarketInfo();
    }
}
