package mg.finance.mapper;

import mg.finance.entity.CurrencyStatistics;
import mg.finance.dto.CurrencyStatisticsDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, CurrencyMapper.class})
public abstract class CurrencyStatisticsMapper {

    public static final CurrencyStatisticsMapper INSTANCE = Mappers.getMapper(CurrencyStatisticsMapper.class);

    public abstract CurrencyStatistics mapToEntity(CurrencyStatisticsDto dto);

    public abstract CurrencyStatisticsDto mapToDTO(CurrencyStatistics entity);
}
