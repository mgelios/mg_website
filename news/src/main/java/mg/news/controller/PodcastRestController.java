package mg.news.controller;

import lombok.AllArgsConstructor;
import mg.news.service.RadiotPodcastService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/podcast")
@AllArgsConstructor
public class PodcastRestController {

    private final RadiotPodcastService radiotPodcastService;

    @GetMapping("/radiot/list")
    public Object getRadiotPodcasts() {
        return radiotPodcastService.getRadiotPodcasts();
    }
}
