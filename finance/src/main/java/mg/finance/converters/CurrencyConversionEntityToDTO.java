package mg.finance.converters;

import mg.finance.dbentities.CurrencyConversionDBEntity;
import mg.finance.models.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionEntityToDTO implements Converter<CurrencyConversionDBEntity, CurrencyConversion> {

    @Autowired
    CurrencyEntityToDTO currencyEntityToDTO;

    @Override
    public CurrencyConversion convert(CurrencyConversionDBEntity source) {
        CurrencyConversion target = new CurrencyConversion();
        target.setId(source.getId());
        target.setValue(source.getValue());
        target.setCurrencyTo(currencyEntityToDTO.convert(source.getCurrencyTo()));
        target.setCurrencyFrom(currencyEntityToDTO.convert(source.getCurrencyFrom()));
        return target;
    }
}
