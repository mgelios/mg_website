package mg.finance.conrtoller;

import lombok.AllArgsConstructor;
import mg.finance.dto.CurrencyDto;
import mg.finance.service.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/finance/currency")
@AllArgsConstructor
public class CurrencyRestController {

    private final CurrencyService currencyService;

    @GetMapping("/list")
    public List<CurrencyDto> getCurrencyValues() {
        return currencyService.getDefaultCurrencies();
    }
}
