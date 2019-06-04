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
public class CryptoCurrencyService {

    @Autowired
    private FinanceConfiguration financeConfiguration;
    @Autowired
    private CurrencyUrlBuilder currencyUrlBuilder;
    @Autowired
    private JSONConsumer jsonConsumer;
    @Autowired
    private JSONHelper jsonHelper;
    @Autowired
    private CryptoCurrencyRepository cryptoCurrencyRepository;
    @Autowired
    private CryptoCurrencyDTOToEntity cryptoCurrencyDTOToEntity;
    @Autowired
    private CryptoCurrencyEntityToDTO cryptoCurrencyEntityToDTO;

    public List<CryptoCurrency> getCryptoCurrencies() {
        Optional<CryptoCurrencyDBEntity> optionalCryptoCurrency = cryptoCurrencyRepository.findTopByOrderByIdDesc();
        List<CryptoCurrencyDBEntity> cryptoCurrencies = new ArrayList<>();
        if (!optionalCryptoCurrency.isPresent() ||
                optionalCryptoCurrency.get().getLastUpdated().toLocalDateTime().getMinute() != LocalDateTime.now().getMinute()) {
            cryptoCurrencies = updateCryptoCurrencies();
        } else {
            cryptoCurrencyRepository.findAll().forEach(cryptoCurrencies::add);
        }
        return cryptoCurrencies.stream()
                .map(cryptoCurrencyEntityToDTO::convert)
                .collect(Collectors.toList());
    }

    public List<CryptoCurrencyDBEntity> updateCryptoCurrencies() {
        JSONArray jsonArray = jsonConsumer.getJsonArray(currencyUrlBuilder.buildCryptoCurrenciesUrl());
        if (cryptoCurrencyRepository.findTopByOrderByIdDesc().isPresent()) {
            cryptoCurrencyRepository.deleteAll();
        }
        return saveCryptoCurrency(jsonArray);
    }

    private List<CryptoCurrencyDBEntity> saveCryptoCurrency(JSONArray jsonArray) {
        List<CryptoCurrencyDBEntity> result = new ArrayList<>();
        for (Object item : jsonArray) {
            JSONObject jsonItem = (JSONObject) item;
            CryptoCurrencyDBEntity cryptoCurrencyDBEntity = new CryptoCurrencyDBEntity();
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
    }

}
