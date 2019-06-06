package mg.blog.controller;

import mg.blog.service.ArticleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogRestController {

    private ArticleService articleService;

    @GetMapping("/article/{id}")
    public Object getArticle(@PathVariable String id) {
        return null;
    }

    @PostMapping("/article/{id}")
    public Object createArticle(@PathVariable String id) {
        return null;
    }
}
