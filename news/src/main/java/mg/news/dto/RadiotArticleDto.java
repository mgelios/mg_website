package mg.news.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class RadiotArticleDto {

    private UUID uuid;
    private String title;
    private String content;
    private String snippet;
    private String mainPicture;
    private String link;
    private String author;
    private OffsetDateTime originalTime;
    private OffsetDateTime radiotTime;
    private String feed;
    private String slug;
    private Long comments;
    private Long likes;
    private OffsetDateTime lastUpdated;
}
