package mg.finance.converters;

import mg.finance.dbentities.CurrencyStatisticsDBEntity;
import mg.finance.models.CurrencyStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class CurrencyStatisticsToCurrencyStatisticsDBEntity implements Converter<CurrencyStatistics, CurrencyStatisticsDBEntity> {

    @Autowired
    CurrencyToCurrencyDBEntity currencyToCurrencyDBEntity;

    @Override
    public CurrencyStatisticsDBEntity convert(CurrencyStatistics source) {
        CurrencyStatisticsDBEntity target = new CurrencyStatisticsDBEntity();
        target.setId(source.getId());
        target.setRate(source.getRate());
        target.setDate(Timestamp.valueOf(source.getDate()));
        target.setCurrency(currencyToCurrencyDBEntity.convert(source.getCurrency()));
        return target;
    }
}
