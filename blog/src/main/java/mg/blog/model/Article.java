package mg.blog.model;

import lombok.Data;
import mg.profile.models.LocalUser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class Article {

    private Long id;
    private LocalUser author;
    private String title;
    private String content;
    private LocalDateTime lastUpdated;
    private Set<Tag> tags;
    private Subcategory subcategory;
    private List<Comment> comments;
}
