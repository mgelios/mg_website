package mg.blog.dbentity;

import lombok.Data;
import mg.blog.model.Subcategory;
import mg.profile.dbentities.UserDBEntity;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
public class ArticleDBEntity {

    private Long id;
    @OneToOne
    private UserDBEntity author;
    private String title;
    private String shortDescription;
    private String content;
    private Timestamp lastUpdated;
    @ManyToOne
    private Set<TagDBEntity> tags;
    private SubcategoryDBEntity subcategory;
    private List<CommentDBEntity> comments;
}
