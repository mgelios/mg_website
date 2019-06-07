package mg.news.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RadiotPodcastTimeLabel {

    private Long id;
    private RadiotPodcast podcast;
    private String topic;
    private Long duration;
    private LocalDateTime time;
}
