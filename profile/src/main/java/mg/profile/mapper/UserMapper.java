package mg.profile.mapper;

import mg.profile.dto.UserDto;
import mg.profile.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapToDto(User entity);

    User mapToEntity(UserDto dto);
}
