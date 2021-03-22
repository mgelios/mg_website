package mg.finance.utils;

import lombok.AllArgsConstructor;
import mg.finance.CoinMarketCapConfig;
import mg.finance.NBRBConfiguration;
import mg.utils.url.UrlBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(NBRBConfiguration.class)
@AllArgsConstructor
public class CoinMarketCapUrlBuilder {

    private final CoinMarketCapConfig coinMarketCapConfig;

    private static final String COIN_MARKET_CAP_API_V1 = "v1";
    private static final String COIN_MARKET_CAP_API_V2 = "v2";
    private static final Integer CRYPTO_CURRENCIES_FETCH_LIMIT = 100;

    //TODO: look into coinmarketcap doc to adjust url to real one if needed
    public String buildCryptoCurrenciesUrl() {
        //result.append("https://api.coinmarketcap.com/v1/ticker/?limit=100");
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(coinMarketCapConfig.getHost())
                .addPathPart(COIN_MARKET_CAP_API_V1)
                .addPathPart(coinMarketCapConfig.getListingsPathPart())
                .addQueryParameter(coinMarketCapConfig.getLimitParameter(), String.valueOf(CRYPTO_CURRENCIES_FETCH_LIMIT))
                .build().getUrl();
    }

    //TODO: update to real coinmarketcap url if possible
    public String buildCryptoCurrenciesMarketUrl() {
        //result.append("https://api.coinmarketcap.com/v1/global/");
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(coinMarketCapConfig.getHost())
                .addPathPart(COIN_MARKET_CAP_API_V1)
                .addPathPart(coinMarketCapConfig.getQuotesGlobalMetricsPathPart())
                .build().getUrl();
    }
}
