package mg.finance.converters;

import mg.finance.dbentities.CurrencyConversionDBEntity;
import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.models.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionDBEntityToCurrencyConversion implements Converter<CurrencyConversionDBEntity, CurrencyConversion> {

    @Autowired
    CurrencyDBEntityToCurrency currencyDBEntityToCurrency;

    @Override
    public CurrencyConversion convert(CurrencyConversionDBEntity source) {
        CurrencyConversion target = new CurrencyConversion();
        target.setId(source.getId());
        target.setValue(source.getId());
        target.setCurrencyTo(currencyDBEntityToCurrency.convert(source.getCurrencyTo()));
        target.setCurrencyFrom(currencyDBEntityToCurrency.convert(source.getCurrencyFrom()));
        return target;
    }
}
