package mg.finance.conrtollers;

import mg.finance.services.*;
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
    CurrencyStatisticsService currencyStatisticsService;
    @Autowired
    CurrencyConversionService currencyConversionService;
    @Autowired
    CryptoCurrencyService cryptoCurrencyService;
    @Autowired
    CryptoMarketService cryptoMarketService;

    @RequestMapping("/currency/values")
    public Object getCurrencyValues() {
        return currencyService.getDefaultCurrencies();
    }

    @RequestMapping("/currency/statistics")
    public Object getCurrencyStatistics() {
        return currencyStatisticsService.getDefaultCurrencyStatistics();
    }

    @RequestMapping("/currency/conversions")
    public Object getCurrencyConversions(){
        return currencyConversionService.getDefaultCurrencyConversions();
    }

    @RequestMapping("/crypto/list")
    public Object getCryptoCurrencies() {
        return cryptoCurrencyService.getCryptoCurrencies();
    }

    @RequestMapping("/crypto/market")
    public Object getCryptoMarketInfo() {
        return cryptoMarketService.getCryptoMarketInfo();
    }
}
