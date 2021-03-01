package mg.finance.conrtoller;

import lombok.AllArgsConstructor;
import mg.finance.dto.CurrencyStatisticsDto;
import mg.finance.service.CurrencyStatisticsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/finance/statistics")
@AllArgsConstructor
public class CurrencyStatisticsRestController {

    private final CurrencyStatisticsService currencyStatisticsService;

    @GetMapping("/list")
    public Map<String, List<CurrencyStatisticsDto>> getCurrencyStatistics() {
        return currencyStatisticsService.getDefaultCurrencyStatistics();
    }
}
