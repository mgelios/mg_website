package mg.finance.mapper;

import mg.finance.dbentities.CurrencyDBEntity;
import mg.finance.models.Currency;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class)
public abstract class CurrencyMapper {

    public static final CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    @Mapping(target = "statistics", ignore = true)
    public abstract CurrencyDBEntity mapToEntity(Currency dto);

    public abstract Currency mapToDTO(CurrencyDBEntity entity);
}
