package mg.finance.services;

import mg.finance.FinanceConfiguration;
import mg.finance.converters.CryptoCurrencyDTOToEntity;
import mg.finance.converters.CryptoCurrencyEntityToDTO;
import mg.finance.converters.CryptoMarketDTOToEntity;
import mg.finance.converters.CryptoMarketEntityToDTO;
import mg.finance.dbentities.CryptoMarketDBEntity;
import mg.finance.models.CryptoMarket;
import mg.finance.repositories.CryptoMarketRepository;
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
    FinanceConfiguration financeConfiguration;
    @Autowired
    CurrencyUrlBuilder currencyUrlBuilder;
    @Autowired
    JSONConsumer jsonConsumer;
    @Autowired
    JSONHelper jsonHelper;
    @Autowired
    CryptoMarketRepository cryptoMarketRepository;
    @Autowired
    CryptoMarketDTOToEntity cryptoMarketDTOToEntity;
    @Autowired
    CryptoMarketEntityToDTO cryptoMarketEntityToDTO;

    public CryptoMarket getCryptoMarketInfo() {
        Optional<CryptoMarketDBEntity> cryptoMarket = cryptoMarketRepository.findTopByOrderByIdDesc();
        if (!cryptoMarket.isPresent() ||
                cryptoMarket.get().getLastUpdated().toLocalDateTime().getMinute() != LocalDateTime.now().getMinute()) {
            updateCryptoMarket();
            cryptoMarket = cryptoMarketRepository.findTopByOrderByIdDesc();
        }
        return cryptoMarketEntityToDTO.convert(cryptoMarket.get());
    }

    public void updateCryptoMarket() {
        JSONObject json = jsonConsumer.getJsonObject(currencyUrlBuilder.buildCryptoCurrenciesMarketUrl());
        if (cryptoMarketRepository.findTopByOrderByIdDesc().isPresent()) {
            cryptoMarketRepository.deleteAll();
        }
        saveCryptoMarket(json);
    }

    private void saveCryptoMarket(JSONObject json) {
        CryptoMarketDBEntity cryptoMarket = new CryptoMarketDBEntity();
        cryptoMarket.setActiveCurrencies(jsonHelper.getLong(json,"active_currencies"));
        cryptoMarket.setActiveMarkets(jsonHelper.getLong(json,"active_markets"));
        cryptoMarket.setBitcoinPercent(jsonHelper.getDouble(json,"bitcoin_percentage_of_market_cap"));
        cryptoMarket.setLastUpdated(jsonHelper.getTimestampOfEpochSecond(json, "last_updated"));
        cryptoMarket.setTotalUsd(jsonHelper.getLong(json,"total_market_cap_usd"));
        cryptoMarket.setTotalUsdDayVolume(jsonHelper.getLong(json,"total_24h_volume_usd"));
        cryptoMarketRepository.save(cryptoMarket);
    }
}
