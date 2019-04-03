package mg.finance.converters;

import mg.finance.dbentities.CryptoCurrencyDBEntity;
import mg.finance.models.CryptoCurrency;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class CryptoCurrencyToCryptoCurrencyDBEntity implements Converter<CryptoCurrency, CryptoCurrencyDBEntity> {

    @Override
    public CryptoCurrencyDBEntity convert(CryptoCurrency source) {
        CryptoCurrencyDBEntity target = new CryptoCurrencyDBEntity();
        target.setId(source.getId());
        target.setAvailableSupply(source.getAvailableSupply());
        target.setLastUpdated(Timestamp.valueOf(source.getLastUpdated()));
        target.setMarketCapUSD(source.getMarketCapUSD());
        target.setMaxSupply(source.getMaxSupply());
        target.setName(source.getName());
        target.setPercentChangeIn1h(source.getPercentChangeIn1h());
        target.setPercentChangeIn24h(source.getPercentChangeIn24h());
        target.setPercentChangeIn7h(source.getPercentChangeIn7h());
        target.setPriceBTC(source.getPriceBTC());
        target.setPriceUSD(source.getPriceUSD());
        target.setRank(source.getRank());
        target.setSymbol(source.getSymbol());
        target.setTotalSupply(source.getTotalSupply());
        target.setVolumeUSD24h(source.getVolumeUSD24h());
        return target;
    }
}
