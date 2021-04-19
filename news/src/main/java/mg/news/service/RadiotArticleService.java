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

    private static final long ARTICLE_EXPIRATION_THRESHOLD_IN_HOURS = 6;

    private final RadiotArticleRepository radiotArticleRepository;
    private final RadiotExternalApiService radiotExternalApiService;
    private final JSONHelper jsonHelper;

    public List<RadiotArticle> getRadiotArticlesList() {
        List<RadiotArticle> dbArticles = new ArrayList<>();
        Optional<RadiotArticle> dbOptionalSingularArticle = radiotArticleRepository.findTopByOrderByOriginalTimeDesc();
        if (dbOptionalSingularArticle.isPresent()) {
            if (isArticleExpired(dbOptionalSingularArticle.get())) {
                radiotArticleRepository.deleteAll();
                dbArticles = updateRadiotArticles();
            } else {
                radiotArticleRepository.findAll().forEach(dbArticles::add);
            }
        } else {
            dbArticles = updateRadiotArticles();
        }
        return dbArticles;
    }

    private boolean isArticleExpired(RadiotArticle article) {
        long hours = article.getLastUpdated().until(OffsetDateTime.now(), ChronoUnit.HOURS);
        return hours > ARTICLE_EXPIRATION_THRESHOLD_IN_HOURS;
    }

    public List<RadiotArticle> updateRadiotArticles() {
        JSONArray json = radiotExternalApiService.fetchArticles();
        if (json != null) {
            return fillRadiotArticles(json);
        } else {
            return new ArrayList<>();
        }
    }

    private List<RadiotArticle> fillRadiotArticles(JSONArray json) {
        List<RadiotArticle> radiotArticleList = new ArrayList<>();
        json.forEach(article -> {
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
    }
}
