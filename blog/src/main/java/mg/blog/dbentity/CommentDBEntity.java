package mg.blog.dbentity;

import lombok.Data;
import mg.profile.dbentities.UserDBEntity;

import java.sql.Timestamp;

@Data
public class CommentDBEntity {

    private Long id;
    private String text;
    private UserDBEntity author;
    private ArticleDBEntity article;
    private Timestamp lastUpdated;
}
