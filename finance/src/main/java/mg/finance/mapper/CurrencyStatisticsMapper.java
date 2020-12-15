package mg.finance.mapper;

import mg.finance.entity.CurrencyStatistics;
import mg.finance.dto.CurrencyStatisticsDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, CurrencyMapper.class}, componentModel = "spring")
public interface CurrencyStatisticsMapper {

    CurrencyStatistics mapToEntity(CurrencyStatisticsDto dto);

    CurrencyStatisticsDto mapToDTO(CurrencyStatistics entity);
}
