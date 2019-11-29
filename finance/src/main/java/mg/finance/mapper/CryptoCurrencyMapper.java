package mg.finance.mapper;

import mg.finance.entity.CryptoCurrency;
import mg.finance.dto.CryptoCurrencyDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public abstract class CryptoCurrencyMapper {

    public static final CryptoCurrencyMapper INSTANCE = Mappers.getMapper(CryptoCurrencyMapper.class);

    public abstract CryptoCurrency mapToEntity(CryptoCurrencyDto dto);

    public abstract CryptoCurrencyDto mapToDTO(CryptoCurrency entity);
}
