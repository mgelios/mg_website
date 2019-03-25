package mg.finance.conrtollers;

import mg.finance.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance")
public class CurrenciesController {

    @Autowired
    CurrencyService currencyService;

    @RequestMapping("/currency/values")
    String getCurrencyValues() {
        currencyService.getDefaultCurrencyValues();
        return null;
    }

    @RequestMapping("/crypto/currencies")
    String getCryptoCurrencyValues() {
        currencyService.getCryptoCurrenciesList();
        return null;
    }

}
