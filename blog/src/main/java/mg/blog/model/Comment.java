package mg.blog.model;

import lombok.Data;
import mg.profile.models.LocalUser;

import java.time.LocalDateTime;

@Data
public class Comment {

    private Long id;
    private String text;
    private LocalUser author;
    private Article article;
    private LocalDateTime lastUpdated;
}
