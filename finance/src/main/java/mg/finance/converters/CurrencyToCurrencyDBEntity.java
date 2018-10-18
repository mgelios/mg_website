package mg.finance.converters;

import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.models.Currency;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class CurrencyToCurrencyDBEntity implements Converter<Currency, CurrencyDBEntity> {

    @Override
    public CurrencyDBEntity convert(Currency source) {
        CurrencyDBEntity target = new CurrencyDBEntity();
        target.setId(source.getId());
        target.setSystemId(source.getSystemId());
        target.setDate(Timestamp.valueOf(source.getDate()));
        target.setAbbreviation(source.getAbbreviation());
        target.setScale(source.getScale());
        target.setName(source.getName());
        target.setRate(source.getRate());
        return target;
    }
}
