package mg.news.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@Table(name="mg_radiot_podcast")
public class RadiotPodcast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "url")
    private String url;
    @Column(name = "title")
    private String title;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "image")
    private String image;
    @Column(name = "body")
    private String body;
    @Column(name = "show_notes")
    private String showNotes;
    @Column(name = "audio_url")
    private String audioUrl;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "podcast", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<RadiotPodcastTimeLabel> timeLabels;
}
