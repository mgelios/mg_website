package mg.finance.mapper;

import mg.finance.dbentities.CryptoCurrencyDBEntity;
import mg.finance.models.CryptoCurrency;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public abstract class CryptoCurrencyMapper {

    public static final CryptoCurrencyMapper INSTANCE = Mappers.getMapper(CryptoCurrencyMapper.class);

    public abstract CryptoCurrencyDBEntity mapToEntity(CryptoCurrency dto);

    public abstract CryptoCurrency mapToDTO(CryptoCurrencyDBEntity entity);
}
