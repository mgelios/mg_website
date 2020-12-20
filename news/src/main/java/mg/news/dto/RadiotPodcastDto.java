package mg.news.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class RadiotPodcastDto {

    private UUID uuid;
    private String url;
    private String title;
    private LocalDateTime date;
    private String image;
    private String body;
    private String showNotes;
    private String audioUrl;
    private Set<RadiotPodcastTimeLabelDto> timeLabels;
}
