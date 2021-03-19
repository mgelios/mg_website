package mg.news.controller;

import lombok.AllArgsConstructor;
import mg.news.service.RadiotPodcastService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/radiot/podcast")
@AllArgsConstructor
public class RadiotPodcastRestController {

    private final RadiotPodcastService radiotPodcastService;

    @GetMapping("/list")
    public Object getRadiotPodcasts() {
        return radiotPodcastService.getRadiotPodcasts();
    }
}
