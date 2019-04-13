package mg.finance.converters;

import mg.finance.dbentities.CryptoMarketDBEntity;
import mg.finance.models.CryptoMarket;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CryptoMarketEntityToDTO implements Converter<CryptoMarketDBEntity, CryptoMarket> {

    @Override
    public CryptoMarket convert(CryptoMarketDBEntity source) {
        CryptoMarket target = new CryptoMarket();
        target.setId(source.getId());
        target.setActiveCurrencies(source.getActiveCurrencies());
        target.setActiveMarkets(source.getActiveMarkets());
        target.setBitcoinPercent(source.getBitcoinPercent());
        target.setLastUpdated(source.getLastUpdated().toLocalDateTime());
        target.setTotalUsd(source.getTotalUsd());
        target.setTotalUsdDayVolume(source.getTotalUsdDayVolume());
        return target;
    }
}
