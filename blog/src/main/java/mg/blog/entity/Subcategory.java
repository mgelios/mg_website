package mg.blog.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="mg_blog_subcategory")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "icon")
    private String icon;
    @Column(name = "description")
    private String description;
}
