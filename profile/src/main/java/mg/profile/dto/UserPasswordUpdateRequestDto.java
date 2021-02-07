package mg.profile.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
public class UserPasswordUpdateRequestDto {

    @NotBlank(message = "UUID is required")
    private UUID uuid;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Minimal length of password is 6 characters")
    private String password;
}
