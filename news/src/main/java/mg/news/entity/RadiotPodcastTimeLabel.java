package mg.news.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="mg_radiot_time_label")
public class RadiotPodcastTimeLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    private Long duration;
    private Timestamp time;
    @ManyToOne
    @JoinColumn(name = "podcast", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private RadiotPodcast podcast;
}
