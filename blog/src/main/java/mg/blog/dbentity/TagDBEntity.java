package mg.blog.dbentity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="mg_blog_tag")
public class TagDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
