package mg.news.controller;

import lombok.AllArgsConstructor;
import mg.news.dto.RadiotArticleDto;
import mg.news.mapper.RadiotArticleMapper;
import mg.news.service.RadiotArticleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/news/")
@AllArgsConstructor
public class NewsRestController {

    private final RadiotArticleService radiotArticleService;
    private final RadiotArticleMapper radiotArticleMapper;

    @GetMapping("/radiot/list")
    public List<RadiotArticleDto> getRadiotArticles() {
        return radiotArticleService.getRadiotArticlesList().stream()
                .map(radiotArticleMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}
