package mg.finance.converters;

import mg.finance.dbentities.CurrencyConversionDBEntity;
import mg.finance.models.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionToCurrencyConversionDBEntity implements Converter<CurrencyConversion, CurrencyConversionDBEntity> {

    @Autowired
    CurrencyToCurrencyDBEntity currencyToCurrencyDBEntity;

    @Override
    public CurrencyConversionDBEntity convert(CurrencyConversion source) {
        CurrencyConversionDBEntity target = new CurrencyConversionDBEntity();
        target.setId(source.getId());
        target.setValue(source.getValue());
        target.setCurrencyFrom(currencyToCurrencyDBEntity.convert(source.getCurrencyFrom()));
        target.setCurrencyTo(currencyToCurrencyDBEntity.convert(source.getCurrencyTo()));
        return target;
    }
}
