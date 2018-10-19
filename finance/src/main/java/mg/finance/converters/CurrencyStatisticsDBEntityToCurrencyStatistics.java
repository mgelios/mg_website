package mg.finance.converters;

import mg.finance.dbentities.CurrencyStatisticsDBEntity;
import mg.finance.models.CurrencyStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CurrencyStatisticsDBEntityToCurrencyStatistics implements Converter<CurrencyStatisticsDBEntity, CurrencyStatistics> {

    @Autowired
    CurrencyDBEntityToCurrency currencyDBEntityToCurrency;

    @Override
    public CurrencyStatistics convert(CurrencyStatisticsDBEntity source) {
        CurrencyStatistics target = new CurrencyStatistics();
        target.setId(source.getId());
        target.setRate(source.getRate());
        target.setDate(source.getDate().toLocalDateTime());
        target.setCurrency(currencyDBEntityToCurrency.convert(source.getCurrency()));
        return target;
    }
}
