package mg.finance.service;

import mg.finance.FinanceConfiguration;
import mg.finance.entity.CurrencyConversion;
import mg.finance.entity.Currency;
import mg.finance.mapper.CurrencyConversionMapper;
import mg.finance.dto.CurrencyConversionDto;
import mg.finance.repository.CurrencyConversionRepository;
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

    public List<CurrencyConversionDto> getDefaultCurrencyConversions() {
        return financeConfiguration.getDefaultConversionCombinations().stream()
                .map(conversionPair -> {
                    return getCurrencyConversion(conversionPair.split("[:]")[0], conversionPair.split("[:]")[1]);
                })
                .collect(Collectors.toList());
    }

    public CurrencyConversionDto getCurrencyConversion(String abbreviationFrom, String abbreviationTo) {
        Currency from = currencyService.getCurrencyDBEntityByAbbreviation(abbreviationFrom);
        Currency to = currencyService.getCurrencyDBEntityByAbbreviation(abbreviationTo);
        if (from != null && to != null) {
            Optional<CurrencyConversion> optionalConversion =
                    currencyConversionRepository.findByCurrencyFromAndCurrencyTo(from, to);
            if (optionalConversion.isPresent()) {
                return CurrencyConversionMapper.INSTANCE.mapToDTO(optionalConversion.get());
            } else {
                return CurrencyConversionMapper.INSTANCE.mapToDTO(updateCurrencyConversion(abbreviationFrom, abbreviationTo));
            }
        } else {
            return null;
        }
    }

    public void updateDefaultCurrencyConversions() {
        financeConfiguration.getDefaultConversionCombinations().forEach(conversionPair -> {
            updateCurrencyConversion(conversionPair.split("[:]")[0], conversionPair.split("[:]")[1]);
        });
    }

    public CurrencyConversion updateCurrencyConversion(String abbreviationFrom, String abbreviationTo) {
        Currency from = currencyService.getCurrencyDBEntityByAbbreviation(abbreviationFrom);
        Currency to = currencyService.getCurrencyDBEntityByAbbreviation(abbreviationTo);
        if (currencyConversionRepository.findAllByCurrencyFromAndCurrencyTo(from, to).size() != 0) {
            currencyConversionRepository.deleteAllByCurrencyFromAndAndCurrencyTo(from, to);
        }
        return saveCurrencyConversion(from, to);
    }

    private CurrencyConversion saveCurrencyConversion(Currency from, Currency to) {
        CurrencyConversion currencyConversionDBEntity = new CurrencyConversion();
        currencyConversionDBEntity.setCurrencyFrom(from);
        currencyConversionDBEntity.setCurrencyTo(to);
        currencyConversionDBEntity.setValue(getConversionValue(from, to));
        return currencyConversionRepository.save(currencyConversionDBEntity);
    }

    private double getConversionValue(Currency from, Currency to) {
        double valueFrom = from.getRate() / from.getScale();
        double valueTo = to.getRate() / to.getScale();
        return valueFrom / valueTo;
    }
}
