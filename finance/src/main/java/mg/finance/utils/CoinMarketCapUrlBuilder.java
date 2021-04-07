package mg.finance.utils;

import lombok.AllArgsConstructor;
import mg.finance.CoinMarketCapConfig;
import mg.finance.NBRBConfiguration;
import mg.utils.url.UrlBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(CoinMarketCapConfig.class)
@AllArgsConstructor
public class CoinMarketCapUrlBuilder {

    private final CoinMarketCapConfig coinMarketCapConfig;

    private static final String COIN_MARKET_CAP_API_V1 = "v1";
    private static final String COIN_MARKET_CAP_API_V2 = "v2";
    private static final Integer CRYPTO_CURRENCIES_FETCH_LIMIT = 100;

    public String buildCryptoCurrenciesUrl() {
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(coinMarketCapConfig.getHost())
                .addPathPart(COIN_MARKET_CAP_API_V1)
                .addPathPart(coinMarketCapConfig.getListingsPathPart())
                .addQueryParameter(coinMarketCapConfig.getLimitParameter(), String.valueOf(CRYPTO_CURRENCIES_FETCH_LIMIT))
                .build().getUrl();
    }

    public String buildCryptoCurrenciesMarketUrl() {
        return (new UrlBuilder.Builder())
                .protocol(UrlBuilder.Builder.HTTPS_PROTOCOL)
                .host(coinMarketCapConfig.getHost())
                .addPathPart(COIN_MARKET_CAP_API_V1)
                .addPathPart(coinMarketCapConfig.getQuotesGlobalMetricsPathPart())
                .build().getUrl();
    }
}
