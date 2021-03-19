package mg.finance.service;

import lombok.AllArgsConstructor;
import mg.finance.FinanceConfiguration;
import mg.finance.entity.CryptoCurrency;
import mg.finance.mapper.CryptoCurrencyMapper;
import mg.finance.dto.CryptoCurrencyDto;
import mg.finance.repository.CryptoCurrencyRepository;
import mg.finance.utils.CoinMarketCapUrlBuilder;
import mg.finance.utils.NBRBCurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CryptoCurrencyService {

    private final CoinMarketCapUrlBuilder currencyUrlBuilder;
    private final JSONConsumer jsonConsumer;
    private final JSONHelper jsonHelper;
    private final CryptoCurrencyRepository cryptoCurrencyRepository;

    public List<CryptoCurrencyDto> getCryptoCurrencies() {
        Optional<CryptoCurrency> optionalCryptoCurrency = cryptoCurrencyRepository.findTopByOrderByIdDesc();
        List<CryptoCurrency> cryptoCurrencies = new ArrayList<>();
        if (!optionalCryptoCurrency.isPresent() ||
                optionalCryptoCurrency.get().getLastUpdated().toLocalDateTime().getMinute() != LocalDateTime.now().getMinute()) {
            cryptoCurrencies = updateCryptoCurrencies();
        } else {
            cryptoCurrencyRepository.findAll().forEach(cryptoCurrencies::add);
        }
        return cryptoCurrencies.stream()
                .map(CryptoCurrencyMapper.INSTANCE::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<CryptoCurrency> updateCryptoCurrencies() {
        JSONArray jsonArray = jsonConsumer.getJsonArray(currencyUrlBuilder.buildCryptoCurrenciesUrl());
        if (cryptoCurrencyRepository.findTopByOrderByIdDesc().isPresent()) {
            cryptoCurrencyRepository.deleteAll();
        }
        return saveCryptoCurrency(jsonArray);
    }

    private List<CryptoCurrency> saveCryptoCurrency(JSONArray jsonArray) {
        if (jsonArray != null) {
            List<CryptoCurrency> result = new ArrayList<>();
            for (Object item : jsonArray) {
                JSONObject jsonItem = (JSONObject) item;
                CryptoCurrency cryptoCurrencyDBEntity = new CryptoCurrency();
                cryptoCurrencyDBEntity.setName(jsonHelper.getString(jsonItem, "name"));
                cryptoCurrencyDBEntity.setSymbol(jsonHelper.getString(jsonItem, "symbol"));
                cryptoCurrencyDBEntity.setRank(jsonHelper.getLong(jsonItem, "rank"));
                cryptoCurrencyDBEntity.setPriceUSD(jsonHelper.getDouble(jsonItem, "price_usd"));
                cryptoCurrencyDBEntity.setPriceBTC(jsonHelper.getDouble(jsonItem, "price_btc"));
                cryptoCurrencyDBEntity.setVolumeUSD24h(jsonHelper.getDouble(jsonItem, "24h_volume_usd"));
                cryptoCurrencyDBEntity.setMarketCapUSD(jsonHelper.getDouble(jsonItem, "market_cap_usd"));
                cryptoCurrencyDBEntity.setAvailableSupply(jsonHelper.getDouble(jsonItem, "available_supply"));
                cryptoCurrencyDBEntity.setTotalSupply(jsonHelper.getDouble(jsonItem, "total_supply"));
                cryptoCurrencyDBEntity.setMaxSupply(jsonHelper.getDouble(jsonItem, "max_supply"));
                cryptoCurrencyDBEntity.setPercentChangeIn1h(jsonHelper.getDouble(jsonItem, "percent_change_1h"));
                cryptoCurrencyDBEntity.setPercentChangeIn24h(jsonHelper.getDouble(jsonItem, "percent_change_24h"));
                cryptoCurrencyDBEntity.setPercentChangeIn7d(jsonHelper.getDouble(jsonItem, "percent_change_7d"));
                cryptoCurrencyDBEntity.setLastUpdated(jsonHelper.getTimestampOfEpochSecond(jsonItem, "last_updated"));
                result.add(cryptoCurrencyRepository.save(cryptoCurrencyDBEntity));
            }
            return result;
        } else {
            return null;
        }
    }

}
