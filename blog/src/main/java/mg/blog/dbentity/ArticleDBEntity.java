package mg.blog.dbentity;

import lombok.Data;
import mg.profile.dbentities.UserDBEntity;

import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.Set;

@Data
public class ArticleDBEntity {

    private Long id;
    @OneToOne
    private UserDBEntity author;
    private String title;
    private String content;
    private Timestamp lastUpdated;
    @ManyToMany
    private Set<TagDBEntity> tags;
}
