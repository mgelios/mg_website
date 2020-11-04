package mg.blog.service;

import mg.blog.dto.ArticleDto;
import mg.blog.entity.Article;
import mg.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article getArticle(Long articleId) {
        return articleRepository.findById(articleId).get();
    }

    public ArticleDto createArticle(String content) {
        ArticleDto articleDto = new ArticleDto();
        return null;
    }

    public Article updateArticle(String content, Long articleId) {
        Article dbArticle = articleRepository.findById(articleId).get();
        dbArticle.setContent(content);
        return articleRepository.save(dbArticle);
    }

    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }
}
