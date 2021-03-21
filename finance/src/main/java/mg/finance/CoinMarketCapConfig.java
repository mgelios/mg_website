package mg.finance;

import lombok.Getter;
import lombok.Setter;
import mg.utils.properties.YamlPropertyLoaderFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/finance.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "mg.coinmarketcap")
@Getter
@Setter
public class CoinMarketCapConfig {

    private String host;
    private String apiVersionPathPart;
    private String listingsPathPart;
    private String startParameter;
    private String limitParameter;
    private String convertToCurrencyParameter;
}
