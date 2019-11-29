package mg.finance.mapper;

import mg.finance.entity.CurrencyConversion;
import mg.finance.dto.CurrencyConversionDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, CurrencyMapper.class})
public abstract class CurrencyConversionMapper {

    public static final CurrencyConversionMapper INSTANCE = Mappers.getMapper(CurrencyConversionMapper.class);

    public abstract CurrencyConversion mapToEntity(CurrencyConversionDto dto);

    public abstract CurrencyConversionDto mapToDTO(CurrencyConversion entity);
}
