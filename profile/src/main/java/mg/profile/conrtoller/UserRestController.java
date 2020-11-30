package mg.profile.conrtoller;

import lombok.AllArgsConstructor;
import mg.profile.dto.UserDto;
import mg.profile.mapper.UserMapper;
import mg.profile.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("/api/v1/profile")
@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/{uuid}")
    public UserDto getUserByUuid(@PathVariable String uuid) {
        return UserMapper.INSTANCE.mapToDto(userService.findUserByUuid(UUID.fromString(uuid)));
    }
}
