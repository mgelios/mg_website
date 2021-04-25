package mg.news.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
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
    private String feed;
    private String slug;
    private Long comments;
    private Long likes;
    private OffsetDateTime originalTime;
    private OffsetDateTime radiotTime;
    private OffsetDateTime lastUpdated;
}
