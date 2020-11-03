package mg.blog.mapper;

import mg.blog.entity.CategoryDBEntity;
import mg.blog.dto.Category;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, SubcategoryMapper.class})
public abstract class CategoryMapper {

    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    public abstract CategoryDBEntity mapToEntity(Category dto);

    public abstract Category mapToDTO(CategoryDBEntity entity);
}
