package mg.profile.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationRequestDto {

    @NotBlank(message = "Username is required")
    @Size(min = 6, message = "Minimal length of username is 6 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Minimal length of password is 6 characters")
    private String password;

    @NotBlank(message = "First name is required")
    @Size(min = 2, message = "Minimal length of first name is 2 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, message = "Minimal length of last name is 2 characters")
    private String lastName;

    @NotBlank(message = "email is required")
    @Size(min = 5, message = "Minimal length of email is 5 characters")
    private String email;
}
