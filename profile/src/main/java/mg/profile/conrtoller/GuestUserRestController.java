package mg.profile.conrtoller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mg.profile.dto.UserCreationRequestDto;
import mg.profile.dto.UserResponseDto;
import mg.profile.mapper.UserMapper;
import mg.profile.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/guest/profile")
public class GuestUserRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public UserResponseDto registerNewUser(@Valid @RequestBody UserCreationRequestDto userCreationDto) {
        return userMapper.mapToResponseDto(userService.createUser(userCreationDto));
    }
}
