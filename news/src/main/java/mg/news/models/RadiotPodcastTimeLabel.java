package mg.news.models;

import java.sql.Timestamp;

public class RadiotPodcastTimeLabel {

    private Long id;
    private RadiotPodcast podcast;
    private String topic;
    private Long duration;
    private Timestamp time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RadiotPodcast getPodcast() {
        return podcast;
    }

    public void setPodcast(RadiotPodcast podcast) {
        this.podcast = podcast;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
