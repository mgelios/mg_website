package mg.profile.dto;

import lombok.Getter;
import lombok.Setter;
import mg.profile.common.Role;

import java.util.UUID;

@Getter
@Setter
public class UserResponseDto {

    private UUID uuid;
    private Role role;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled;
}
