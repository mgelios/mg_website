package mg.finance.service.crypto;

import lombok.AllArgsConstructor;
import mg.finance.CoinMarketCapConfig;
import mg.finance.utils.CoinMarketCapUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.api.consumer.ApiConsumerService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@AllArgsConstructor
public class CryptoExternalApiService {

    private static final String COIN_MARKET_CAP_API_KEY_HEADER_NAME = "X-CMC_PRO_API_KEY";

    private final CoinMarketCapUrlBuilder coinMarketCapUrlBuilder;
    private final CoinMarketCapConfig coinMarketCapConfig;
    private final JSONConsumer jsonConsumer;
    private final ApiConsumerService apiConsumerService;

    public JSONArray fetchCryptoCurrencies() {
        return jsonConsumer.getJsonObject(
                coinMarketCapUrlBuilder.buildCryptoCurrenciesUrl(),
                getCoinMarketCapHeaders()
        ).getJSONArray("data");
    }

    public JSONObject fetchCryptoMarketInfo() {
        return jsonConsumer.getJsonObject(
                coinMarketCapUrlBuilder.buildCryptoCurrenciesMarketUrl(),
                getCoinMarketCapHeaders()
        );
    }

    private Map<String, String> getCoinMarketCapHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        String apiKey = apiConsumerService.findByName(coinMarketCapConfig.getApiClientName()).getApiKey();
        headers.put(COIN_MARKET_CAP_API_KEY_HEADER_NAME, apiKey);
        return headers;
    }
}
