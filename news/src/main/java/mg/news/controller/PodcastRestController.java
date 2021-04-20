package mg.news.controller;

import lombok.AllArgsConstructor;
import mg.news.dto.RadiotPodcastDto;
import mg.news.mapper.RadiotPodcastMapper;
import mg.news.service.RadiotPodcastService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/podcast")
@AllArgsConstructor
public class PodcastRestController {

    private final RadiotPodcastService radiotPodcastService;
    private final RadiotPodcastMapper radiotPodcastMapper;

    @GetMapping("/radiot/list")
    public List<RadiotPodcastDto> getRadiotPodcasts() {
        return radiotPodcastService.getRadiotPodcasts().stream()
                .map(radiotPodcastMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}
