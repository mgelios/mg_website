package mg.finance.service;

import lombok.AllArgsConstructor;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CurrencyExternalApiService {

    private final CurrencyUrlBuilder currencyUrlBuilder;
    private final JSONConsumer jsonConsumer;

    public JSONObject fetchCurrencyRate(String abbreviation) {
        String url = currencyUrlBuilder.buildCurrencyRateUrl(abbreviation);
        return jsonConsumer.getJsonObject(url);
    }
}
