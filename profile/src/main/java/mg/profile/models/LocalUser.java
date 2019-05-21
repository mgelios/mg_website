package mg.profile.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class LocalUser implements UserDetails {

    public interface FullValidation {}

    public interface PartialValidation {}

    @Getter
    @Setter
    private Long id;

    @NotNull(message = "Password should not be empty", groups = {FullValidation.class})
    @Size(min=8, max=100, message="Please enter a valid password", groups = {FullValidation.class})
    @Getter
    @Setter
    private String password;

    @NotNull(message = "Username should not be empty", groups = {FullValidation.class})
    @Size(min=2, max=100, message="Please enter a valid username", groups = {FullValidation.class})
    @Getter
    @Setter
    private String username;

    @NotNull(message="Please enter an email", groups = {FullValidation.class, PartialValidation.class})
    @Email(message="Please enter a valid email", groups = {FullValidation.class, PartialValidation.class})
    @Size(min=2, max=100, message="Please enter a valid email", groups = {FullValidation.class, PartialValidation.class})
    @Getter
    @Setter
    private String email;

    @NotNull(groups = {FullValidation.class, PartialValidation.class})
    @Size(min=2, max=100, message="Please enter a valid first name", groups = {FullValidation.class, PartialValidation.class})
    @Getter
    @Setter
    private String firstName;

    @NotNull(groups = {FullValidation.class, PartialValidation.class})
    @Size(min=2, max=100, message="Please enter a valid last name", groups = {FullValidation.class, PartialValidation.class})
    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private Set<Role> roles;

    @Getter
    @Setter
    private boolean accountNonExpired;

    @Getter
    @Setter
    private boolean accountNonLocked;

    @Getter
    @Setter
    private boolean credentialsNonExpired;

    @Getter
    @Setter
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toSet());
    }
}
