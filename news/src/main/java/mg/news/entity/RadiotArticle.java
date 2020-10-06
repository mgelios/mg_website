package mg.news.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="mg_radiot_article")
public class RadiotArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String snippet;
    private String mainPicture;
    private String link;
    private String author;
    private Timestamp originalTime;
    private Timestamp radiotTime;
    private String feed;
    private String slug;
    private Long comments;
    private Long likes;
    private Timestamp lastUpdated;
}
