package mg.finance;

import lombok.Data;
import mg.utils.properties.YamlPropertyLoaderFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Configuration
@PropertySource(value = "classpath:/finance.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "mg.finance")
@Data
public class FinanceConfiguration {

    private String currencyBaseUrl;
    private String currencyStatisticsPathPart;
    private String currencyStatisticsStartDateParameter;
    private String currencyStatisticsEndDateParameter;
    private String currencyUrlParamModeParameter;
    private List<String> defaultCurrencies;
    private List<String> defaultStatisticsCurrencies;
    private List<String> defaultConversionCombinations;
}
