package mg.finance.converters;

import mg.finance.dbentities.CurrencyConversionDBEntity;
import mg.finance.models.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionDTOToEntity implements Converter<CurrencyConversion, CurrencyConversionDBEntity> {

    @Autowired
    CurrencyDTOToEntity currencyDTOToEntity;

    @Override
    public CurrencyConversionDBEntity convert(CurrencyConversion source) {
        CurrencyConversionDBEntity target = new CurrencyConversionDBEntity();
        target.setId(source.getId());
        target.setValue(source.getValue());
        target.setCurrencyFrom(currencyDTOToEntity.convert(source.getCurrencyFrom()));
        target.setCurrencyTo(currencyDTOToEntity.convert(source.getCurrencyTo()));
        return target;
    }
}
