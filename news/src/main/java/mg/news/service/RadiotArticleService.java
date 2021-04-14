package mg.news.service;

import lombok.AllArgsConstructor;
import mg.news.entity.RadiotArticle;
import mg.news.mapper.RadiotArticleMapper;
import mg.news.dto.RadiotArticleDto;
import mg.news.repository.RadiotArticleRepository;
import mg.news.util.RadiotUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RadiotArticleService {

    private static final long ARTICLE_EXPIRATION_THRESHOLD_IN_HOURS = 24;

    private final JSONConsumer jsonConsumer;
    private final JSONHelper jsonHelper;
    private final RadiotUrlBuilder radiotUrlBuilder;
    private final RadiotArticleRepository radiotArticleRepository;
    private final RadiotArticleMapper radiotArticleMapper;

    public List<RadiotArticleDto> getRadiotArticlesList() {
        List<RadiotArticle> dbArticles = new ArrayList<>();
        Optional<RadiotArticle> dbOptionalSingularArticle = radiotArticleRepository.findTopByOrderByOriginalTimeDesc();
        if (dbOptionalSingularArticle.isPresent()) {
            RadiotArticle dbSingularArticle = dbOptionalSingularArticle.get();
            if (isArticleExpired(dbSingularArticle)) {
                radiotArticleRepository.deleteAll();
                dbArticles = fillRadiotArticles();
            } else {
                radiotArticleRepository.findAll().forEach(dbArticles::add);
            }
        } else {
            dbArticles = fillRadiotArticles();
        }
        return dbArticles.stream()
                .map(radiotArticleMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    private boolean isArticleExpired(RadiotArticle article) {
        long hours = article.getLastUpdated().until(OffsetDateTime.now(), ChronoUnit.HOURS);
        return hours > ARTICLE_EXPIRATION_THRESHOLD_IN_HOURS;
    }

    private List<RadiotArticle> fillRadiotArticles() {
        List<RadiotArticle> radiotArticleList = new ArrayList<>();
        JSONArray jsonArticles = jsonConsumer.getJsonArray(radiotUrlBuilder.buildNewsUrl(100));
        if (jsonArticles != null) {
            jsonArticles.forEach(article -> {
                JSONObject jsonArticle = (JSONObject) article;
                RadiotArticle dbArticle = RadiotArticle.builder()
                        .author(jsonHelper.getString(jsonArticle, "author"))
                        .comments(jsonHelper.getLong(jsonArticle, "comments"))
                        .content(jsonHelper.getString(jsonArticle, "content"))
                        .feed(jsonHelper.getString(jsonArticle, "feed"))
                        .likes(jsonHelper.getLong(jsonArticle, "likes"))
                        .link(jsonHelper.getString(jsonArticle, "link"))
                        .mainPicture(jsonHelper.getString(jsonArticle, "pic"))
                        .slug(jsonHelper.getString(jsonArticle, "slug"))
                        .snippet(jsonHelper.getString(jsonArticle, "snippet"))
                        .title(jsonHelper.getString(jsonArticle, "title"))
                        .originalTime(OffsetDateTime.now())
                        .radiotTime(OffsetDateTime.now())
                        .lastUpdated(OffsetDateTime.now())
                        .build();
                dbArticle = radiotArticleRepository.save(dbArticle);
                radiotArticleList.add(dbArticle);
            });
            return radiotArticleList;
        } else {
            return null;
        }
    }
}
