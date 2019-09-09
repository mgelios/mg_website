package mg.blog.dbentity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mg.blog.model.Subcategory;
import mg.profile.dbentities.UserDBEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="mg_blog_article")
public class ArticleDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
//    @Column(name = "author")
//    private UserDBEntity author;
    @Column(name = "title")
    private String title;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "content")
    private String content;
    @Column(name = "timestamp")
    private Timestamp lastUpdated;
    @ManyToOne
    @JoinColumn(name = "subcategory", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private SubcategoryDBEntity subcategory;
//    @ManyToOne
//    private Set<TagDBEntity> tags;
//    private List<CommentDBEntity> comments;
}
