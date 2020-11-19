package mg.profile.entity;

import lombok.Getter;
import lombok.Setter;
import mg.profile.common.Role;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="mg_user")
public class User {

    @Id
    @GeneratedValue
    private UUID uuid;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled;
}
