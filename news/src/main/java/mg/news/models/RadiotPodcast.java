package mg.news.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class RadiotPodcast {

    private Long id;
    private String url;
    private String title;
    private LocalDateTime date;
    private String image;
    private String body;
    private String showNotes;
    private String audioUrl;
    private Set<RadiotPodcastTimeLabel> timeLabels;
}
