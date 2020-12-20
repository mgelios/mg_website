package mg.news.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name="mg_radiot_podcast")
public class RadiotPodcast {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String url;
    private String title;
    private Timestamp date;
    private String image;
    private String body;
    private String showNotes;
    private String audioUrl;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "podcast", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<RadiotPodcastTimeLabel> timeLabels;
}
