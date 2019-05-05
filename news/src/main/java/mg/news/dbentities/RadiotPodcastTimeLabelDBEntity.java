package mg.news.dbentities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="mg_radiot_time_label")
public class RadiotPodcastTimeLabelDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "podcast", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private RadiotPodcastDBEntity podcast;
    @Column(name = "topic")
    private String topic;
    @Column(name = "duration")
    private Long duration;
    @Column(name = "time")
    private Timestamp time;
}
