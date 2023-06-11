package mg.finance.service.crypto;

import lombok.AllArgsConstructor;
import mg.finance.entity.CryptoMarket;
import mg.finance.mapper.CryptoMarketMapper;
import mg.finance.dto.CryptoMarketDto;
import mg.finance.repository.CryptoMarketRepository;
import mg.utils.JSONHelper;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

//@Service
//@Transactional
//@AllArgsConstructor
public class CryptoMarketService {

//    private static final long HOURS_UPDATE_THRESHOLD = 6;
//
//    private final CryptoMarketRepository cryptoMarketRepository;
//    private final CryptoExternalApiService cryptoExternalApiService;
//    private final JSONHelper jsonHelper;
//
//
//    public CryptoMarketDto getCryptoMarketInfo() {
//        Optional<CryptoMarket> optionalCryptoMarket = cryptoMarketRepository.findFirstByActiveCryptoCurrenciesIsNotNull();
//        CryptoMarket cryptoMarket = null;
//        if (optionalCryptoMarket.isEmpty() || isDateTimeLessThanThreshold(optionalCryptoMarket.get().getLastUpdated())) {
//            cryptoMarket = updateCryptoMarket();
//        } else {
//            cryptoMarket = optionalCryptoMarket.get();
//        }
//        return CryptoMarketMapper.INSTANCE.mapToDTO(cryptoMarket);
//    }
//
//    private boolean isDateTimeLessThanThreshold(OffsetDateTime dateTime) {
//        long hours = dateTime.until(OffsetDateTime.now(), ChronoUnit.HOURS);
//        return hours > HOURS_UPDATE_THRESHOLD;
//    }
//
//    public CryptoMarket updateCryptoMarket() {
//        JSONObject json = cryptoExternalApiService.fetchCryptoMarketInfo();
//        if (cryptoMarketRepository.findFirstByActiveCryptoCurrenciesIsNotNull().isPresent()) {
//            cryptoMarketRepository.deleteAll();
//        }
//        return saveCryptoMarket(json);
//    }
//
//    private CryptoMarket saveCryptoMarket(JSONObject json) {
//        if (json != null) {
//            CryptoMarket cryptoMarket = CryptoMarket.builder()
//                    .activeCryptoCurrencies(jsonHelper.getLong(json, "data.active_cryptocurrencies"))
//                    .totalCryptoCurrencies(jsonHelper.getLong(json, "data.total_cryptocurrencies"))
//                    .btcDominance(jsonHelper.getLong(json, "data.btc_dominance"))
//                    .ethDominance(jsonHelper.getLong(json, "data.eth_dominance"))
//                    .totalMarketCapUsd(jsonHelper.getLong(json, "data.quote.USD.total_market_cap"))
//                    .totalDayVolumeUsd(jsonHelper.getLong(json, "data.quote.USD.total_volume_24h"))
//                    .altcoinMarketCapUsd(jsonHelper.getLong(json, "data.quote.USD.altcoin_market_cap"))
//                    .altcoinDayVolumeUsd(jsonHelper.getLong(json, "data.quote.USD.altcoin_volume_24h"))
//                    .lastUpdated(OffsetDateTime.now())
//                    .build();
//            return cryptoMarketRepository.save(cryptoMarket);
//        } else {
//            return null;
//        }
//    }
}
