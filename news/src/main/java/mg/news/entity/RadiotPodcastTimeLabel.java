package mg.news.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name="mg_radiot_time_label")
public class RadiotPodcastTimeLabel {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String topic;
    private Long duration;
    private OffsetDateTime time;
    @ManyToOne
    @JoinColumn(name = "podcast", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private RadiotPodcast podcast;
}
