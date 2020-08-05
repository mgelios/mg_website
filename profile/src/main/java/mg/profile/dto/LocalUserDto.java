package mg.profile.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class LocalUserDto implements UserDetails {

    public interface FullValidation {}

    public interface PartialValidation {}

    private Long id;

    @NotNull(message = "Password should not be empty", groups = {FullValidation.class})
    @Size(min=8, max=100, message="Please enter a valid password", groups = {FullValidation.class})
    private String password;

    @NotNull(message = "Username should not be empty", groups = {FullValidation.class})
    @Size(min=2, max=100, message="Please enter a valid username", groups = {FullValidation.class})
    private String username;

    @NotNull(message="Please enter an email", groups = {FullValidation.class, PartialValidation.class})
    @Email(message="Please enter a valid email", groups = {FullValidation.class, PartialValidation.class})
    @Size(min=2, max=100, message="Please enter a valid email", groups = {FullValidation.class, PartialValidation.class})
    private String email;

    @NotNull(groups = {FullValidation.class, PartialValidation.class})
    @Size(min=2, max=100, message="Please enter a valid first name", groups = {FullValidation.class, PartialValidation.class})
    private String firstName;

    @NotNull(groups = {FullValidation.class, PartialValidation.class})
    @Size(min=2, max=100, message="Please enter a valid last name", groups = {FullValidation.class, PartialValidation.class})
    private String lastName;

    private Set<RoleDto> roles;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
