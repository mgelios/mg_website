package mg.news.controller;

import mg.news.service.RadiotArticleService;
import mg.news.service.RadiotPodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/news")
public class RadiotNewsRestController {

    @Autowired
    RadiotArticleService radiotArticleService;
    @Autowired
    RadiotPodcastService radiotPodcastService;

    @GetMapping("/radiot/articles")
    public Object getRadiotArticles() {
        return radiotArticleService.getRadiotArticlesList();
    }

    @GetMapping("/radiot/podcasts")
    public Object getRadiotPodcasts() {
        return radiotPodcastService.getRadiotPodcasts();
    }
}
