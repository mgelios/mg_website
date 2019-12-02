package mg.finance.conrtoller;

import mg.finance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/finance")
public class CurrenciesRestController {

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

    @GetMapping("/currency/values")
    public Object getCurrencyValues() {
        return currencyService.getDefaultCurrencies();
    }

    @GetMapping("/currency/statistics")
    public Object getCurrencyStatistics() {
        return currencyStatisticsService.getDefaultCurrencyStatistics();
    }

    @GetMapping("/currency/conversions")
    public Object getCurrencyConversions(){
        return currencyConversionService.getDefaultCurrencyConversions();
    }

    @GetMapping("/crypto/list")
    public Object getCryptoCurrencies() {
        return cryptoCurrencyService.getCryptoCurrencies();
    }

    @GetMapping("/crypto/market")
    public Object getCryptoMarketInfo() {
        return cryptoMarketService.getCryptoMarketInfo();
    }
}
