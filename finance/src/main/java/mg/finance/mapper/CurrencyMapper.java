package mg.finance.mapper;

import mg.finance.entity.Currency;
import mg.finance.dto.CurrencyDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = DateMapper.class, componentModel = "spring")
public interface CurrencyMapper {

    Currency mapToEntity(CurrencyDto dto);

    CurrencyDto mapToDTO(Currency entity);
}
