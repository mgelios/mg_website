package mg.finance.converters;

import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.models.Currency;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class CurrencyDBEntityToCurrency implements Converter<CurrencyDBEntity, Currency> {

    @Override
    public Currency convert(CurrencyDBEntity source) {
        Currency target = new Currency();
        target.setId(source.getId());
        target.setSystemId(source.getSystemId());
        target.setDate(source.getDate().toLocalDateTime());
        target.setAbbreviation(source.getAbbreviation());
        target.setScale(source.getScale());
        target.setName(source.getName());
        target.setRate(source.getRate());
        return target;
    }
}
