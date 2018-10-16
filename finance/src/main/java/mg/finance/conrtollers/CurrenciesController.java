package mg.finance.conrtollers;

import mg.finance.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrenciesController {

    @Autowired
    CurrencyService currencyService;

    @RequestMapping("/values")
    String getCurrencyValues(){
        currencyService.getCurrencyValues();
        return null;
    }

}
