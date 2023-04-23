package mg.profile.conrtoller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mg.profile.dto.UserPasswordUpdateRequestDto;
import mg.profile.dto.UserResponseDto;
import mg.profile.dto.UserUpdateRequestDto;
import mg.profile.mapper.UserMapper;
import mg.profile.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/authorized/profile")
public class AuthorizedUserRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public UserResponseDto getUserProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return userMapper.mapToResponseDto(userService.findUserByUsername(username));
    }

    @PutMapping
    public UserResponseDto updateUserProfile(@Valid @RequestBody UserUpdateRequestDto dto) {
        String usernameToCheck = userService.findUserByUuid(dto.getUuid()).getUsername();
        checkIfUserAllowedToPerformAction(usernameToCheck);
        return userMapper.mapToResponseDto(userService.updateUser(dto));
    }

    @PatchMapping
    public UserResponseDto updateUserPassword(@Valid @RequestBody UserPasswordUpdateRequestDto dto) {
        String usernameToCheck = userService.findUserByUuid(dto.getUuid()).getUsername();
        checkIfUserAllowedToPerformAction(usernameToCheck);
        return userMapper.mapToResponseDto(userService.updatePassword(dto));
    }

    @DeleteMapping
    public void deleteUserProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        userService.deleteUser(username);
    }

    private void checkIfUserAllowedToPerformAction(String usernameToCheck) {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        if (!usernameToCheck.equals(username)) {
            throw new RuntimeException("request is not valid");
        }
    }
}
