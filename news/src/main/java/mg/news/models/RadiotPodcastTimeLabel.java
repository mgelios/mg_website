package mg.news.models;

import java.time.LocalDateTime;

public class RadiotPodcastTimeLabel {

    private Long id;
    private RadiotPodcast podcast;
    private String topic;
    private Long duration;
    private LocalDateTime time;

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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
