package mg.finance.utils;

import lombok.AllArgsConstructor;
import mg.finance.NBRBConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(NBRBConfiguration.class)
@AllArgsConstructor
public class CoinMarketCapUrlBuilder {

    public String buildCryptoCurrenciesUrl() {
        StringBuilder result = new StringBuilder();
        result.append("https://api.coinmarketcap.com/v1/ticker/?limit=100");
        return result.toString();
    }

    public String buildCryptoCurrenciesMarketUrl() {
        StringBuilder result = new StringBuilder();
        result.append("https://api.coinmarketcap.com/v1/global/");
        return result.toString();
    }
}
