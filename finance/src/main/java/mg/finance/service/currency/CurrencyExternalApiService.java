package mg.finance.service.currency;

import lombok.AllArgsConstructor;
import mg.finance.utils.NBRBCurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CurrencyExternalApiService {

    private final NBRBCurrencyUrlBuilder currencyUrlBuilder;
    private final JSONConsumer jsonConsumer;

    public JSONObject fetchCurrencyRate(String abbreviation) {
        String url = currencyUrlBuilder.buildCurrencyRateUrl(abbreviation);
        return jsonConsumer.getJsonObject(url);
    }

    public JSONArray fetchCurrencyStatistics(String systemId) {
        String url = currencyUrlBuilder.buildCurrency365DaysStatisticsUrl(systemId);
        return jsonConsumer.getJsonArray(url);
    }
}
