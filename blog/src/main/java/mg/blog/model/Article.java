package mg.blog.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Article {

    private Long id;
//    private LocalUser author;
    private String title;
    private String shortDescription;
    private String content;
    private LocalDateTime lastUpdated;
//    private Set<Tag> tags;
    private Subcategory subcategory;
//    private List<Comment> comments;
}
