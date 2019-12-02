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
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "snippet")
    private String snippet;
    @Column(name = "main_picture")
    private String mainPicture;
    @Column(name = "link")
    private String link;
    @Column(name = "author")
    private String author;

    @Column(name = "original_time")
    private Timestamp originalTime;
    @Column(name = "radiot_time")
    private Timestamp radiotTime;

    @Column(name = "feed")
    private String feed;
    @Column(name = "slug")
    private String slug;

    @Column(name = "comments")
    private Long comments;
    @Column(name = "likes")
    private Long likes;

    @Column(name = "last_updated")
    private Timestamp lastUpdated;
}
