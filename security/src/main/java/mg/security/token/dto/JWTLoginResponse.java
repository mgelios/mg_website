package mg.security.token.dto;

import lombok.*;
import mg.profile.dto.UserDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class JWTLoginResponse {

    private String token;
    private UserDto profile;
}
