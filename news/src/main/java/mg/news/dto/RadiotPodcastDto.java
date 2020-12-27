package mg.news.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class RadiotPodcastDto {

    private UUID uuid;
    private String url;
    private String title;
    private OffsetDateTime date;
    private String image;
    private String body;
    private String showNotes;
    private String audioUrl;
    private Set<RadiotPodcastTimeLabelDto> timeLabels;
}
