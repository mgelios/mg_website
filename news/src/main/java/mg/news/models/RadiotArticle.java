package mg.news.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RadiotArticle {

    private Long id;

    private String title;
    private String content;
    private String snippet;
    private String mainPicture;
    private String link;
    private String author;

    private LocalDateTime originalTime;
    private LocalDateTime radiotTime;

    private String feed;
    private String slug;

    private Long comments;
    private Long likes;

    private LocalDateTime lastUpdated;
}
