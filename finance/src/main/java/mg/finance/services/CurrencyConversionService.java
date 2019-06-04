package mg.finance.services;

import mg.finance.FinanceConfiguration;
import mg.finance.converters.CurrencyConversionDTOToEntity;
import mg.finance.converters.CurrencyConversionEntityToDTO;
import mg.finance.dbentities.CurrencyConversionDBEntity;
import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.models.CurrencyConversion;
import mg.finance.repositories.CurrencyConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CurrencyConversionService {

    @Autowired
    private FinanceConfiguration financeConfiguration;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;
    @Autowired
    private CurrencyConversionDTOToEntity currencyConversionDTOToEntity;
    @Autowired
    private CurrencyConversionEntityToDTO currencyConversionEntityToDTO;

    public List<CurrencyConversion> getDefaultCurrencyConversions() {
        return financeConfiguration.getDefaultConversionCombinations().stream()
                .map(conversionPair -> {
                    return getCurrencyConversion(conversionPair.split("[:]")[0], conversionPair.split("[:]")[1]);
                })
                .collect(Collectors.toList());
    }

    public CurrencyConversion getCurrencyConversion(String abbreviationFrom, String abbreviationTo) {
        CurrencyDBEntity from = currencyService.getCurrencyDBEntityByAbbreviation(abbreviationFrom);
        CurrencyDBEntity to = currencyService.getCurrencyDBEntityByAbbreviation(abbreviationTo);
        Optional<CurrencyConversionDBEntity> optionalConversion =
                currencyConversionRepository.findByCurrencyFromAndCurrencyTo(from, to);
        if (optionalConversion.isPresent()) {
            return currencyConversionEntityToDTO.convert(optionalConversion.get());
        } else {
            return currencyConversionEntityToDTO.convert(updateCurrencyConversion(abbreviationFrom, abbreviationTo));
        }
    }

    public void updateDefaultCurrencyConversions() {
        financeConfiguration.getDefaultConversionCombinations().forEach(conversionPair -> {
            updateCurrencyConversion(conversionPair.split("[:]")[0], conversionPair.split("[:]")[1]);
        });
    }

    public CurrencyConversionDBEntity updateCurrencyConversion(String abbreviationFrom, String abbreviationTo) {
        CurrencyDBEntity from = currencyService.getCurrencyDBEntityByAbbreviation(abbreviationFrom);
        CurrencyDBEntity to = currencyService.getCurrencyDBEntityByAbbreviation(abbreviationTo);
        if (currencyConversionRepository.findAllByCurrencyFromAndCurrencyTo(from, to).size() != 0) {
            currencyConversionRepository.deleteAllByCurrencyFromAndAndCurrencyTo(from, to);
        }
        return saveCurrencyConversion(from, to);
    }

    private CurrencyConversionDBEntity saveCurrencyConversion(CurrencyDBEntity from, CurrencyDBEntity to) {
        CurrencyConversionDBEntity currencyConversionDBEntity = new CurrencyConversionDBEntity();
        currencyConversionDBEntity.setCurrencyFrom(from);
        currencyConversionDBEntity.setCurrencyTo(to);
        currencyConversionDBEntity.setValue(getConversionValue(from, to));
        return currencyConversionRepository.save(currencyConversionDBEntity);
    }

    private double getConversionValue(CurrencyDBEntity from, CurrencyDBEntity to) {
        double valueFrom = from.getRate() / from.getScale();
        double valueTo = to.getRate() / to.getScale();
        return valueFrom / valueTo;
    }
}
