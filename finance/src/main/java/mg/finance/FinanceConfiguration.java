package mg.finance;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/finance.properties")
@ConfigurationProperties(prefix = "mg.finance")
@Data
public class FinanceConfiguration {

    private String currencyBaseUrl;
    private String currencyRateSuffix;
    private String currencyUrlParamMode;

}
