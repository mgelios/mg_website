package mg.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="mg_blog_comment")
public class CommentDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "text")
    private String text;
//    @Column(name = "author")
//    private UserDBEntity author;
//    @Column(name = "article")
//    private ArticleDBEntity article;
    @Column(name = "last_updated")
    private Timestamp lastUpdated;
}
