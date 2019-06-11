package mg.finance.mapper;

import mg.finance.dbentities.CurrencyConversionDBEntity;
import mg.finance.models.CurrencyConversion;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, CurrencyMapper.class})
public abstract class CurrencyConversionMapper {

    public static final CurrencyConversionMapper INSTANCE = Mappers.getMapper(CurrencyConversionMapper.class);

    public abstract CurrencyConversionDBEntity mapToEntity(CurrencyConversion dto);

    public abstract CurrencyConversion mapToDTO(CurrencyConversionDBEntity entity);
}
