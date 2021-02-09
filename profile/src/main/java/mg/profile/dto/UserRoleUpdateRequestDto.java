package mg.profile.dto;

import lombok.Getter;
import lombok.Setter;
import mg.profile.common.Role;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class UserRoleUpdateRequestDto {

    @NotBlank(message = "UUID is required")
    private UUID uuid;

    @NotBlank(message = "Password is required")
    private Role role;
}
