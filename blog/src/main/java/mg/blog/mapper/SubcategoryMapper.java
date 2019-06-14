package mg.blog.mapper;

import mg.blog.dbentity.SubcategoryDBEntity;
import mg.blog.model.Subcategory;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class})
public abstract class SubcategoryMapper {

    public static final SubcategoryMapper INSTANCE = Mappers.getMapper(SubcategoryMapper.class);

    public abstract SubcategoryDBEntity mapToEntity(Subcategory dto);

    public abstract Subcategory mapToDTO(SubcategoryDBEntity entity);
}
