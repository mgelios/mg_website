package mg.blog.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {

    private Long id;
    private String text;
    //private LocalUser author;
    //private Article article;
    private LocalDateTime lastUpdated;
}
