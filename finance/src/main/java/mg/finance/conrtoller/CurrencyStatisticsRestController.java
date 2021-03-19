package mg.finance.conrtoller;

import lombok.AllArgsConstructor;
import mg.finance.dto.CurrencyStatisticsDto;
import mg.finance.mapper.CurrencyStatisticsMapper;
import mg.finance.service.currency.CurrencyStatisticsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/finance/statistics")
@AllArgsConstructor
public class CurrencyStatisticsRestController {

    private final CurrencyStatisticsService currencyStatisticsService;
    private final CurrencyStatisticsMapper currencyStatisticsMapper;

    @GetMapping("/map")
    public Map<String, List<CurrencyStatisticsDto>> getCurrencyStatistics() {
        return currencyStatisticsService.getDefaultCurrencyStatistics().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .map(currencyStatisticsMapper::mapToDTO)
                                .collect(Collectors.toList())
                ));
    }
}
