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

    //TODO : chagne returning dto to more complex, probably add userDto to cut unnecessary additional requests
    @PostMapping("/login")
    public JWTLoginResponse login(@RequestBody JWTLoginRequest loginRequest) {
        String token = jwtService.generateJWTToken(loginRequest);
        return new JWTLoginResponse(token);
    }
}
