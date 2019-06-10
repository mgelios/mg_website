package mg.finance.mapper;

import mg.finance.dbentities.CryptoMarketDBEntity;
import mg.finance.models.CryptoMarket;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public abstract class CryptoMarketMapper {

    public static final CryptoMarketMapper INSTANCE = Mappers.getMapper(CryptoMarketMapper.class);

    public abstract CryptoMarketDBEntity mapToEntity(CryptoMarket dto);

    public abstract CryptoMarket mapToDTO(CryptoMarketDBEntity entity);
}
