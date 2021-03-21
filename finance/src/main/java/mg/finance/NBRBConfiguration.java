package mg.finance;

import lombok.Getter;
import lombok.Setter;
import mg.utils.properties.YamlPropertyLoaderFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource(value = "classpath:/finance.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "mg.nbrb")
@Getter
@Setter
public class NBRBConfiguration {

    private String host;
    private String currencyPathPart;
    private String currencyStatisticsPathPart;
    private String currencyStatisticsStartDateParameter;
    private String currencyStatisticsEndDateParameter;
    private String currencyUrlParamModeParameter;
    private List<String> defaultCurrencies;
    private List<String> defaultStatisticsCurrencies;
    private List<String> defaultConversionCombinations;
}
