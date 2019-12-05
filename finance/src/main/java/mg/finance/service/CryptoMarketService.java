package mg.finance.service;

import mg.finance.FinanceConfiguration;
import mg.finance.entity.CryptoMarket;
import mg.finance.mapper.CryptoMarketMapper;
import mg.finance.dto.CryptoMarketDto;
import mg.finance.repository.CryptoMarketRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class CryptoMarketService {

    @Autowired
    private FinanceConfiguration financeConfiguration;
    @Autowired
    private CurrencyUrlBuilder currencyUrlBuilder;
    @Autowired
    private JSONConsumer jsonConsumer;
    @Autowired
    private JSONHelper jsonHelper;
    @Autowired
    private CryptoMarketRepository cryptoMarketRepository;

    public CryptoMarketDto getCryptoMarketInfo() {
        Optional<CryptoMarket> optionalCryptoMarket = cryptoMarketRepository.findTopByOrderByIdDesc();
        CryptoMarket cryptoMarket = null;
        if (!optionalCryptoMarket.isPresent() ||
                optionalCryptoMarket.get().getLastUpdated().toLocalDateTime().getMinute() != LocalDateTime.now().getMinute()) {
            cryptoMarket = updateCryptoMarket();
        } else {
            cryptoMarket = optionalCryptoMarket.get();
        }
        return CryptoMarketMapper.INSTANCE.mapToDTO(cryptoMarket);
    }

    public CryptoMarket updateCryptoMarket() {
        JSONObject json = jsonConsumer.getJsonObject(currencyUrlBuilder.buildCryptoCurrenciesMarketUrl());
        if (cryptoMarketRepository.findTopByOrderByIdDesc().isPresent()) {
            cryptoMarketRepository.deleteAll();
        }
        return saveCryptoMarket(json);
    }

    private CryptoMarket saveCryptoMarket(JSONObject json) {
        if (json != null) {
            CryptoMarket cryptoMarket = new CryptoMarket();
            cryptoMarket.setActiveCurrencies(jsonHelper.getLong(json, "active_currencies"));
            cryptoMarket.setActiveMarkets(jsonHelper.getLong(json, "active_markets"));
            cryptoMarket.setBitcoinPercent(jsonHelper.getDouble(json, "bitcoin_percentage_of_market_cap"));
            cryptoMarket.setLastUpdated(jsonHelper.getTimestampOfEpochSecond(json, "last_updated"));
            cryptoMarket.setTotalUsd(jsonHelper.getLong(json, "total_market_cap_usd"));
            cryptoMarket.setTotalUsdDayVolume(jsonHelper.getLong(json, "total_24h_volume_usd"));
            return cryptoMarketRepository.save(cryptoMarket);
        } else {
            return null;
        }
    }
}
