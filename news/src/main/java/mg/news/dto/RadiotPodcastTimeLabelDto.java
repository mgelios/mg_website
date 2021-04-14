package mg.news.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class RadiotPodcastTimeLabelDto {

    private UUID uuid;
    private RadiotPodcastDto podcast;
    private String topic;
    private Long duration;
    private OffsetDateTime time;
}
