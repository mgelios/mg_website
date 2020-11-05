package mg.blog.mapper;

import mg.blog.dto.SubcategoryDto;
import mg.blog.entity.Subcategory;
import mg.utils.mapper.DateMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DateMapper.class})
public abstract class SubcategoryMapper {

    public static final SubcategoryMapper INSTANCE = Mappers.getMapper(SubcategoryMapper.class);

    public abstract Subcategory mapToEntity(SubcategoryDto dto);

    public abstract SubcategoryDto mapToDTO(Subcategory entity);
}
