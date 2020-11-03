package mg.blog.service;

import mg.blog.dto.ArticleDto;
import mg.blog.entity.ArticleDBEntity;
import mg.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleDBEntity getArticle(Long articleId) {
        return articleRepository.findById(articleId).get();
    }

    public ArticleDto createArticle(String content) {
        ArticleDto articleDto = new ArticleDto();
        return null;
    }

    public ArticleDBEntity updateArticle(String content, Long articleId) {
        ArticleDBEntity dbArticle = articleRepository.findById(articleId).get();
        dbArticle.setContent(content);
        return articleRepository.save(dbArticle);
    }

    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }
}
