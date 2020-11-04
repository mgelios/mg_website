package mg.blog.mapper;

import mg.blog.entity.Category;
import mg.blog.dto.CategoryDto;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class, SubcategoryMapper.class})
public abstract class CategoryMapper {

    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    public abstract Category mapToEntity(CategoryDto dto);

    public abstract CategoryDto mapToDTO(Category entity);
}
