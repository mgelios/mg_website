package mg.common.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

public class LocalUser implements UserDetails {

    public interface FullValidation {
    }

    public interface PartialValidation {
    }

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

    private Set<Role> roles;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
