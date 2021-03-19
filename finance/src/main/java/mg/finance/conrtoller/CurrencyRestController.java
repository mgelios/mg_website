package mg.finance.conrtoller;

import lombok.AllArgsConstructor;
import mg.finance.dto.CurrencyDto;
import mg.finance.mapper.CurrencyMapper;
import mg.finance.service.currency.CurrencyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/finance/currency")
@AllArgsConstructor
public class CurrencyRestController {

    private final CurrencyService currencyService;
    private final CurrencyMapper currencyMapper;

    @GetMapping("/list")
    public List<CurrencyDto> getCurrencyValues() {
        return currencyService.getDefaultCurrencies().stream()
                .map(currencyMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}
