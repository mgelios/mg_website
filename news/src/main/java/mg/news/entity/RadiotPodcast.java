package mg.news.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name="mg_radiot_podcast")
@NoArgsConstructor
@AllArgsConstructor
public class RadiotPodcast {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String url;
    private String title;
    private String image;
    private String body;
    private String showNotes;
    private String audioUrl;
    private OffsetDateTime date;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "podcast", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<RadiotPodcastTimeLabel> timeLabels;
}
