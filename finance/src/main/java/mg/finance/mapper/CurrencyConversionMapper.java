package mg.finance.mapper;

import mg.finance.entity.CurrencyConversion;
import mg.finance.dto.CurrencyConversionDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, CurrencyMapper.class}, componentModel = "spring")
public interface CurrencyConversionMapper {

    CurrencyConversion mapToEntity(CurrencyConversionDto dto);

    CurrencyConversionDto mapToDTO(CurrencyConversion entity);
}
