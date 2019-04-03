package mg.finance.converters;

import mg.finance.dbentities.CryptoMarketDBEntity;
import mg.finance.models.CryptoMarket;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class CryptoMarketToCryptoMarketDBEntity implements Converter<CryptoMarket, CryptoMarketDBEntity> {

    @Override
    public CryptoMarketDBEntity convert(CryptoMarket source) {
        CryptoMarketDBEntity target = new CryptoMarketDBEntity();
        target.setId(source.getId());
        target.setActiveCurrencies(source.getActiveCurrencies());
        target.setActiveMarkets(source.getActiveMarkets());
        target.setBitcoinPercent(source.getBitcoinPercent());
        target.setLastUpdated(Timestamp.valueOf(source.getLastUpdated()));
        target.setTotalUsd(source.getTotalUsd());
        target.setTotalUsdDayVolume(source.getTotalUsdDayVolume());
        return target;
    }
}
