package mg.finance.mapper;

import mg.finance.entity.Currency;
import mg.finance.dto.CurrencyDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public abstract class CurrencyMapper {

    public static final CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    @Mapping(target = "statistics", ignore = true)
    public abstract Currency mapToEntity(CurrencyDto dto);

    public abstract CurrencyDto mapToDTO(Currency entity);
}
