package mg.news.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RadiotPodcastTimeLabelDto {

    private Long id;
    private RadiotPodcastDto podcast;
    private String topic;
    private Long duration;
    private LocalDateTime time;
}
