package mg.profile.conrtoller;

import lombok.AllArgsConstructor;
import mg.profile.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/profile/")
@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;
}
