package mg.news.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name="mg_radiot_article")
public class RadiotArticle {

    @Id
    @GeneratedValue
    private UUID uuid;
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
