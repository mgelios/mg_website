package mg.security.token;

import lombok.AllArgsConstructor;
import mg.security.token.dto.JWTLoginRequest;
import mg.security.token.dto.JWTLoginResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/token")
@AllArgsConstructor
public class JWTLoginController {

    private final JWTService jwtService;

    @PostMapping("/login")
    public JWTLoginResponse login(@RequestBody JWTLoginRequest loginRequest) {
        return jwtService.generateLoginResponse(loginRequest);
    }
}
