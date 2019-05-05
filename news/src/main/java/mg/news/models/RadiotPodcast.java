package mg.news.models;

import java.time.LocalDateTime;
import java.util.Set;

public class RadiotPodcast {

    private Long id;
    private String url;
    private String title;
    private LocalDateTime date;
    private String image;
    private String body;
    private String showNotes;
    private String audioUrl;
    private Set<RadiotPodcastTimeLabel> timeLabels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShowNotes() {
        return showNotes;
    }

    public void setShowNotes(String showNotes) {
        this.showNotes = showNotes;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public Set<RadiotPodcastTimeLabel> getTimeLabels() {
        return timeLabels;
    }

    public void setTimeLabels(Set<RadiotPodcastTimeLabel> timeLabels) {
        this.timeLabels = timeLabels;
    }
}
