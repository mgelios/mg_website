package mg.profile.conrtoller;

import lombok.AllArgsConstructor;
import mg.profile.dto.*;
import mg.profile.mapper.UserMapper;
import mg.profile.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/profile")
public class AdminUserRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{uuid}")
    public UserResponseDto getUserProfileByUuid(@PathVariable String uuid) {
        return userMapper.mapToResponseDto(userService.findUserByUuid(UUID.fromString(uuid)));
    }

    @PostMapping
    public UserResponseDto createUserProfile(@Valid @RequestBody UserCreationRequestDto userCreationDto) {
        return userMapper.mapToResponseDto(userService.createUser(userCreationDto));
    }

    @PutMapping
    public UserResponseDto updateUserProfile(@Valid @RequestBody UserUpdateRequestDto dto) {
        return userMapper.mapToResponseDto(userService.updateUser(dto));
    }

    @PatchMapping("/password")
    public UserResponseDto updateUserPassword(@Valid @RequestBody UserPasswordUpdateRequestDto dto) {
        return userMapper.mapToResponseDto(userService.updatePassword(dto));
    }

    @PatchMapping("/role")
    public UserResponseDto updateUserRole(@Valid @RequestBody UserRoleUpdateRequestDto dto) {
        return userMapper.mapToResponseDto(userService.updateRole(dto));
    }

    @DeleteMapping("/{uuid}")
    public void deleteProfileByUuid(@PathVariable String uuid) {
        userService.deleteUserByUuid(UUID.fromString(uuid));
    }
}
