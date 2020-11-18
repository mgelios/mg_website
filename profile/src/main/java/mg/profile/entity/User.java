package mg.profile.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name="mg_user")
public class User {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled;
}
