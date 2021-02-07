package mg.profile.mapper;

import mg.profile.dto.UserCreationRequestDto;
import mg.profile.dto.UserDto;
import mg.profile.dto.UserResponseDto;
import mg.profile.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapToDto(User entity);

    UserResponseDto mapToResponseDto(User entity);

    User mapToEntity(UserDto dto);

    User mapToEntity(UserCreationRequestDto dto);

    User mapToEntity(UserResponseDto dto);
}
