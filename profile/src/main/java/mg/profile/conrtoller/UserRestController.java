package mg.profile.conrtoller;

import lombok.AllArgsConstructor;
import mg.profile.dto.UserDto;
import mg.profile.dto.UserResponseDto;
import mg.profile.mapper.UserMapper;
import mg.profile.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/profile")
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;

//    @GetMapping("/{uuid}")
//    public UserDto getUserByUuid(@PathVariable String uuid) {
//        return userMapper.mapToDto(userService.findUserByUuid(UUID.fromString(uuid)));
//    }

    @GetMapping
    public UserResponseDto getAuthorizedUserProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return userMapper.mapToResponseDto(userService.findUserByUsername(username));
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto dto) {
        return userMapper.mapToDto(userService.createUser(dto));
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto dto) {
        return userMapper.mapToDto(userService.updateUser(dto));
    }

    @DeleteMapping("/{uuid}")
    public void deleteUserByUuid(@PathVariable String uuid) {
        userService.deleteUser(UUID.fromString(uuid));
    }
}
