package mg.common.dbentities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="mg_role")
public class RoleDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
