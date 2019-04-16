package mg.finance.services;

import mg.finance.FinanceConfiguration;
import mg.finance.converters.CryptoCurrencyDTOToEntity;
import mg.finance.converters.CryptoCurrencyEntityToDTO;
import mg.finance.dbentities.CryptoCurrencyDBEntity;
import mg.finance.models.CryptoCurrency;
import mg.finance.repositories.CryptoCurrencyRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImprovedCryptoCurrencyService {

    @Autowired
    FinanceConfiguration financeConfiguration;
    @Autowired
    CurrencyUrlBuilder currencyUrlBuilder;
    @Autowired
    JSONConsumer jsonConsumer;
    @Autowired
    JSONHelper jsonHelper;
    @Autowired
    CryptoCurrencyRepository cryptoCurrencyRepository;
    @Autowired
    CryptoCurrencyDTOToEntity cryptoCurrencyDTOToEntity;
    @Autowired
    CryptoCurrencyEntityToDTO cryptoCurrencyEntityToDTO;

    public List<CryptoCurrency> getCryptoCurrencies() {
        Optional<CryptoCurrencyDBEntity> optionalCryptoCurrency = cryptoCurrencyRepository.findTopByOrderByIdDesc();
        List<CryptoCurrencyDBEntity> cryptoCurrencies = new ArrayList<>();
        if (!optionalCryptoCurrency.isPresent() ||
                optionalCryptoCurrency.get().getLastUpdated().toLocalDateTime().getMinute() != LocalDateTime.now().getMinute()) {
            updateCryptoCurrencies();
        }
        cryptoCurrencyRepository.findAll().forEach(cryptoCurrencies::add);
        return cryptoCurrencies.stream()
                .map(cryptoCurrencyEntityToDTO::convert)
                .collect(Collectors.toList());
    }

    public void updateCryptoCurrencies() {
        JSONArray jsonArray = jsonConsumer.getJsonArray(currencyUrlBuilder.buildCryptoCurrenciesUrl());
        if (cryptoCurrencyRepository.findTopByOrderByIdDesc().isPresent()) {
            cryptoCurrencyRepository.deleteAll();
        }
        saveCryptoCurrency(jsonArray);
    }

    private void saveCryptoCurrency(JSONArray jsonArray) {
        for (Object item : jsonArray) {
            Double maxSupply = ((JSONObject) item).get("max_supply").getClass() == JSONObject.NULL.getClass() ? 0 : ((JSONObject) item).getDouble("max_supply");
            CryptoCurrencyDBEntity cryptoCurrencyDBEntity = new CryptoCurrencyDBEntity();
            cryptoCurrencyDBEntity.setName(((JSONObject) item).getString("name"));
            cryptoCurrencyDBEntity.setSymbol(((JSONObject) item).getString("symbol"));
            cryptoCurrencyDBEntity.setRank(((JSONObject) item).getLong("rank"));
            cryptoCurrencyDBEntity.setPriceUSD(((JSONObject) item).getDouble("price_usd"));
            cryptoCurrencyDBEntity.setPriceBTC(((JSONObject) item).getDouble("price_btc"));
            cryptoCurrencyDBEntity.setVolumeUSD24h(((JSONObject) item).getDouble("24h_volume_usd"));
            cryptoCurrencyDBEntity.setMarketCapUSD(((JSONObject) item).getDouble("market_cap_usd"));
            cryptoCurrencyDBEntity.setAvailableSupply(((JSONObject) item).getDouble("available_supply"));
            cryptoCurrencyDBEntity.setTotalSupply(((JSONObject) item).getDouble("total_supply"));
            cryptoCurrencyDBEntity.setMaxSupply(maxSupply);
            cryptoCurrencyDBEntity.setPercentChangeIn1h(((JSONObject) item).getDouble("percent_change_1h"));
            cryptoCurrencyDBEntity.setPercentChangeIn24h(((JSONObject) item).getDouble("percent_change_24h"));
            cryptoCurrencyDBEntity.setPercentChangeIn7d(((JSONObject) item).getDouble("percent_change_7d"));
            cryptoCurrencyDBEntity.setLastUpdated(jsonHelper.getTimestampOfEpochSecond((JSONObject) item, "last_updated"));
            cryptoCurrencyRepository.save(cryptoCurrencyDBEntity);
        }
    }

}
