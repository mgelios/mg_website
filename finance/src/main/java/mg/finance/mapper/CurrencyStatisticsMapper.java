package mg.finance.mapper;

import mg.finance.dbentities.CurrencyStatisticsDBEntity;
import mg.finance.models.CurrencyStatistics;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, CurrencyMapper.class})
public abstract class CurrencyStatisticsMapper {

    public static final CurrencyStatisticsMapper INSTANCE = Mappers.getMapper(CurrencyStatisticsMapper.class);

    public abstract CurrencyStatisticsDBEntity mapToEntity(CurrencyStatistics dto);

    public abstract CurrencyStatistics mapToDTO(CurrencyStatisticsDBEntity entity);
}
