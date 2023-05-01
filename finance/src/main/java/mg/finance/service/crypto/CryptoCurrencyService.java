package mg.finance.service.crypto;

import lombok.AllArgsConstructor;
import mg.finance.entity.CryptoCurrency;
import mg.finance.mapper.CryptoCurrencyMapper;
import mg.finance.dto.CryptoCurrencyDto;
import mg.finance.repository.CryptoCurrencyRepository;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service
//@Transactional
//@AllArgsConstructor
public class CryptoCurrencyService {
//
//    private static final long MINUTES_UPDATE_THRESHOLD = 30;
//
//    private final CryptoCurrencyRepository cryptoCurrencyRepository;
//    private final CryptoExternalApiService cryptoExternalApiService;
//    private final JSONHelper jsonHelper;
//
//    public List<CryptoCurrencyDto> getCryptoCurrencies() {
//        Optional<CryptoCurrency> optionalCryptoCurrency = cryptoCurrencyRepository.findFirstByMarketCapUsdNotNull();
//        List<CryptoCurrency> cryptoCurrencies = new ArrayList<>();
//        if (optionalCryptoCurrency.isEmpty() || isDateTimeLessThanThreshold(optionalCryptoCurrency.get().getLastUpdated())) {
//            cryptoCurrencies = updateCryptoCurrencies();
//        } else {
//            cryptoCurrencyRepository.findAll().forEach(cryptoCurrencies::add);
//        }
//        return cryptoCurrencies.stream()
//                .map(CryptoCurrencyMapper.INSTANCE::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    private boolean isDateTimeLessThanThreshold(OffsetDateTime dateTime) {
//        long minutes = dateTime.until(OffsetDateTime.now(), ChronoUnit.MINUTES);
//        return minutes > MINUTES_UPDATE_THRESHOLD;
//    }
//
//    public List<CryptoCurrency> updateCryptoCurrencies() {
//        JSONArray jsonArray = cryptoExternalApiService.fetchCryptoCurrencies();
//        if (cryptoCurrencyRepository.findFirstByMarketCapUsdNotNull().isPresent()) {
//            cryptoCurrencyRepository.deleteAll();
//        }
//        return saveCryptoCurrency(jsonArray);
//    }
//
//    private List<CryptoCurrency> saveCryptoCurrency(JSONArray jsonArray) {
//        if (jsonArray != null) {
//            List<CryptoCurrency> result = new ArrayList<>();
//            for (Object item : jsonArray) {
//                JSONObject jsonItem = (JSONObject) item;
//                CryptoCurrency cryptoCurrencyDBEntity = CryptoCurrency.builder()
//                        .name(jsonHelper.getString(jsonItem, "name"))
//                        .symbol(jsonHelper.getString(jsonItem, "symbol"))
//                        .rank(jsonHelper.getLong(jsonItem, "rank"))
//                        .availableSupply(jsonHelper.getDouble(jsonItem, "available_supply"))
//                        .totalSupply(jsonHelper.getDouble(jsonItem, "total_supply"))
//                        .maxSupply(jsonHelper.getDouble(jsonItem, "max_supply"))
//                        .priceUsd(jsonHelper.getDouble(jsonItem, "quote.USD.price"))
//                        .volumeLastDayUsd(jsonHelper.getDouble(jsonItem, "quote.USD.volume_24h"))
//                        .marketCapUsd(jsonHelper.getDouble(jsonItem, "quote.USD.market_cap"))
//                        .percentChangeLastHour(jsonHelper.getDouble(jsonItem, "quote.USD.percent_change_1h"))
//                        .percentChangeLastDay(jsonHelper.getDouble(jsonItem, "quote.USD.percent_change_24h"))
//                        .percentChangeLastWeek(jsonHelper.getDouble(jsonItem, "quote.USD.percent_change_7d"))
//                        .percentChangeLastMonth(jsonHelper.getDouble(jsonItem, "quote.USD.percent_change_30d"))
//                        .percentChangeLastThreeMonth(jsonHelper.getDouble(jsonItem, "quote.USD.percent_change_90d"))
//                        .lastUpdated(OffsetDateTime.now())
//                        .build();
//                result.add(cryptoCurrencyRepository.save(cryptoCurrencyDBEntity));
//            }
//            return result;
//        } else {
//            return null;
//        }
//    }

}
