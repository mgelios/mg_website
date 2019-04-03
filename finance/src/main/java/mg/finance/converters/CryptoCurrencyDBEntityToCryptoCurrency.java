package mg.finance.converters;

import mg.finance.dbentities.CryptoCurrencyDBEntity;
import mg.finance.models.CryptoCurrency;
import org.springframework.core.convert.converter.Converter;

public class CryptoCurrencyDBEntityToCryptoCurrency implements Converter<CryptoCurrencyDBEntity, CryptoCurrency> {

    @Override
    public CryptoCurrency convert(CryptoCurrencyDBEntity source) {
        CryptoCurrency target = new CryptoCurrency();
        target.setId(source.getId());
        target.setAvailableSupply(source.getAvailableSupply());
        target.setLastUpdated(source.getLastUpdated().toLocalDateTime());
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
