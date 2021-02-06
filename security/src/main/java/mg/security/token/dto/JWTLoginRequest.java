package mg.security.token.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JWTLoginRequest {

    @NotNull(message = "username is missing")
    private String username;

    @NotNull(message = "password is missing")
    private String password;
}
