package mg.finance.conrtoller;

import lombok.AllArgsConstructor;
import mg.finance.dto.CurrencyConversionDto;
import mg.finance.mapper.CurrencyConversionMapper;
import mg.finance.service.CurrencyConversionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/finance/conversion")
@AllArgsConstructor
public class CurrencyConversionRestController {

    private final CurrencyConversionService currencyConversionService;
    private final CurrencyConversionMapper currencyConversionMapper;

    @GetMapping("/list")
    public List<CurrencyConversionDto> getCurrencyConversions(){
        return currencyConversionService.getDefaultCurrencyConversions().stream()
                .map(currencyConversionMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}
