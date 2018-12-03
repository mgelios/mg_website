package mg.finance.converters;

import mg.finance.dbentities.CryptoCurrencyDBEntity;
import mg.finance.models.CryptoCurrency;
import org.springframework.core.convert.converter.Converter;

public class CryptoCurrencyDBEntityToCryptoCurrency implements Converter<CryptoCurrencyDBEntity, CryptoCurrency> {

    @Override
    public CryptoCurrency convert(CryptoCurrencyDBEntity source) {
        CryptoCurrency target = new CryptoCurrency();
        target.setId(source.getId());
        return null;
    }
}
