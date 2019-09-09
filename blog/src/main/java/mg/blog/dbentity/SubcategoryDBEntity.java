package mg.blog.dbentity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="mg_blog_subcategory")
public class SubcategoryDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}
