package mg.news.controllers;

import mg.news.services.RadiotArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/news")
public class RestRadiotNewsController {

    @Autowired
    RadiotArticleService radiotArticleService;
}
