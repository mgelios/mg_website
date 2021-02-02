package mg.security.token.dto;

import lombok.*;
import mg.profile.dto.UserDto;
import mg.profile.dto.UserResponseDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class JWTLoginResponse {

    private String token;
    private UserResponseDto profile;
}
