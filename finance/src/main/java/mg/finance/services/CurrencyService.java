package mg.finance.services;

import lombok.Synchronized;
import mg.finance.FinanceConfiguration;
import mg.finance.converters.CurrencyDTOToEntity;
import mg.finance.converters.CurrencyEntityToDTO;
import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.models.Currency;
import mg.finance.repositories.CurrencyRepository;
import mg.finance.utils.CurrencyUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CurrencyService {

    @Autowired
    FinanceConfiguration financeConfiguration;
    @Autowired
    CurrencyUrlBuilder currencyUrlBuilder;
    @Autowired
    JSONConsumer jsonConsumer;
    @Autowired
    JSONHelper jsonHelper;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    CurrencyDTOToEntity currencyDTOToEntity;
    @Autowired
    CurrencyEntityToDTO currencyEntityToDTO;

    public List<Currency> getDefaultCurrencies() {
        return financeConfiguration.getDefaultCurrencies().stream()
                .map(this::getCurrencyByAbbreviation)
                .collect(Collectors.toList());
    }

    public Currency getCurrencyByAbbreviation(String abbreviation) {
        return currencyEntityToDTO.convert(getCurrencyDBEntityByAbbreviation(abbreviation));
    }

    public CurrencyDBEntity getCurrencyDBEntityByAbbreviation(String abbreviation) {
        Optional<CurrencyDBEntity> optionalCurrency = currencyRepository.findByAbbreviation(abbreviation);
        CurrencyDBEntity result = null;
        if (optionalCurrency.isPresent()) {
            result = optionalCurrency.get();
        }
        if (result == null || result.getDate().toLocalDateTime().getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
            updateCurrency(abbreviation);
            result = currencyRepository.findByAbbreviation(abbreviation).get();
        }
        return result;
    }

    public void updateDefaultCurrencies() {
        financeConfiguration.getDefaultCurrencies().forEach(this::updateCurrency);
    }

    public void updateCurrency(String abbreviation) {
        JSONObject json = jsonConsumer.getJsonObject(currencyUrlBuilder.buildCurrencyRateUrl(abbreviation));
        if (currencyRepository.findAllByAbbreviation(abbreviation).size() != 0) {
            currencyRepository.deleteAllByAbbreviation(abbreviation);
        }
        saveCurrencyDBEntity(json);
    }

    public void saveCurrencyDBEntity(JSONObject json) {
        CurrencyDBEntity dbEntity = new CurrencyDBEntity();
        dbEntity.setSystemId(jsonHelper.getInt(json,"Cur_ID"));
        dbEntity.setDate(Timestamp.valueOf(jsonHelper.getString(json,"Date").replace("T", " ")));
        dbEntity.setAbbreviation(jsonHelper.getString(json,"Cur_Abbreviation"));
        dbEntity.setScale(jsonHelper.getDouble(json,"Cur_Scale"));
        dbEntity.setName(jsonHelper.getString(json,"Cur_Name"));
        dbEntity.setRate(jsonHelper.getDouble(json,"Cur_OfficialRate"));
        currencyRepository.save(dbEntity);
    }
}
