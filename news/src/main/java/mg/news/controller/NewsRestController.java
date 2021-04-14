package mg.news.controller;

import lombok.AllArgsConstructor;
import mg.news.service.RadiotArticleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/news/")
@AllArgsConstructor
public class NewsRestController {

    private final RadiotArticleService radiotArticleService;

    @GetMapping("/radiot/list")
    public Object getRadiotArticles() {
        return radiotArticleService.getRadiotArticlesList();
    }
}
