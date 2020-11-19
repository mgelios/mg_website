package mg.profile.mapper;

import mg.profile.dto.UserDto;
import mg.profile.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserDto mapToDto(User entity);

    public abstract User mapToEntity(UserDto dto);
}
