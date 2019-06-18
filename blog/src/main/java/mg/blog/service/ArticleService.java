package mg.blog.service;

import mg.blog.model.Article;
import mg.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article createArticle(String content) {
        Article article = new Article();
        SecurityContextHolder.getContext().getAuthentication().getName();
        return null;
    }
}
