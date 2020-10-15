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

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RadiotArticleService {

    private final JSONConsumer jsonConsumer;
    private final JSONHelper jsonHelper;
    private final RadiotUrlBuilder radiotUrlBuilder;
    private final RadiotArticleRepository radiotArticleRepository;

    public List<RadiotArticleDto> getRadiotArticlesList() {
        List<RadiotArticle> dbArticles = new ArrayList<>();
        Optional<RadiotArticle> dbOptionalSingularArticle = radiotArticleRepository.findTopByOrderByIdDesc();
        if (dbOptionalSingularArticle.isPresent()) {
            RadiotArticle dbSingularArticle = dbOptionalSingularArticle.get();
            if (dbSingularArticle.getLastUpdated().toLocalDateTime().getDayOfYear() != LocalDateTime.now().getDayOfYear()) {
                radiotArticleRepository.deleteAll();
                dbArticles = fillRadiotArticles();
            } else {
                radiotArticleRepository.findAll().forEach(dbArticles::add);
            }
        } else {
            dbArticles = fillRadiotArticles();
        }
        return dbArticles.stream()
                .map(RadiotArticleMapper.INSTANCE::mapToDTO)
                .collect(Collectors.toList());
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
                        .originalTime(Timestamp.from(Instant.now()))
                        .radiotTime(Timestamp.from(Instant.now()))
                        .lastUpdated(Timestamp.from(Instant.now()))
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
