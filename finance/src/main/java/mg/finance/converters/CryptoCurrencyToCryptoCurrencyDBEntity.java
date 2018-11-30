package mg.finance.converters;

import mg.finance.dbentities.CryptoCurrencyDBEntity;
import mg.finance.models.CryptoCurrency;
import org.springframework.core.convert.converter.Converter;

public class CryptoCurrencyToCryptoCurrencyDBEntity implements Converter<CryptoCurrency, CryptoCurrencyDBEntity> {

    @Override
    public CryptoCurrencyDBEntity convert(CryptoCurrency source) {
        return null;
    }
}
