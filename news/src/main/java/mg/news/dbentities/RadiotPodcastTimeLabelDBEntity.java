package mg.news.dbentities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="mg_radiot_time_label")
public class RadiotPodcastTimeLabelDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

}
