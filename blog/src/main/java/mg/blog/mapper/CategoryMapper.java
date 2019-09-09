package mg.blog.mapper;

import mg.blog.dbentity.CategoryDBEntity;
import mg.blog.model.Category;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, SubcategoryMapper.class})
public abstract class CategoryMapper {

    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    public abstract CategoryDBEntity mapToEntity(Category dto);

    public abstract Category mapToDTO(CategoryDBEntity entity);
}
