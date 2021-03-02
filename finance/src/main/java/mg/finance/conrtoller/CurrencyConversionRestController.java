package mg.finance.conrtoller;

import lombok.AllArgsConstructor;
import mg.finance.dto.CurrencyConversionDto;
import mg.finance.service.CurrencyConversionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/finance/conversion")
@AllArgsConstructor
public class CurrencyConversionRestController {

    private final CurrencyConversionService currencyConversionService;

    @GetMapping("/list")
    public List<CurrencyConversionDto> getCurrencyConversions(){
        return currencyConversionService.getDefaultCurrencyConversions();
    }
}
