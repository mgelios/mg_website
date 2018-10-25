package mg.news.models;

import java.time.LocalDateTime;

public class RadiotArticle {

    private Long id;

    private String title;
    private String content;
    private String snippet;
    private String mainPicture;
    private String link;
    private String author;

    private LocalDateTime originalTime;
    private LocalDateTime radiotTime;

    private String feed;
    private String slug;

    private Long comments;
    private Long likes;

    private LocalDateTime lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getOriginalTime() {
        return originalTime;
    }

    public void setOriginalTime(LocalDateTime originalTime) {
        this.originalTime = originalTime;
    }

    public LocalDateTime getRadiotTime() {
        return radiotTime;
    }

    public void setRadiotTime(LocalDateTime radiotTime) {
        this.radiotTime = radiotTime;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
