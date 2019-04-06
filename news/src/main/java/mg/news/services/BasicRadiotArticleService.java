package mg.news.services;

import mg.news.converter.RadiotArticleDTOToEntity;
import mg.news.converter.RadiotArticleEntityToDTO;
import mg.news.dbentities.RadiotArticleDBEntity;
import mg.news.models.RadiotArticle;
import mg.news.repositories.RadiotArticleRepository;
import mg.news.utils.RadiotUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BasicRadiotArticleService implements RadiotArticleService {

    @Autowired
    JSONConsumer jsonConsumer;
    @Autowired
    JSONHelper jsonHelper;
    @Autowired
    RadiotUrlBuilder radiotUrlBuilder;
    @Autowired
    RadiotArticleRepository radiotArticleRepository;
    @Autowired
    RadiotArticleDTOToEntity radiotArticleDTOToEntity;
    @Autowired
    RadiotArticleEntityToDTO radiotArticleEntityToDTO;


    public List<RadiotArticle> getRadiotArticlesList() {
        List<RadiotArticleDBEntity> dbArticles = new ArrayList<>();
        Optional<RadiotArticleDBEntity> dbOptionalSingularArticle = radiotArticleRepository.findTopByOrderByIdDesc();
        if (dbOptionalSingularArticle.isPresent()) {
            RadiotArticleDBEntity dbSingularArticle = dbOptionalSingularArticle.get();
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
                .map(radiotArticleEntityToDTO::convert)
                .collect(Collectors.toList());
    }

    private List<RadiotArticleDBEntity> fillRadiotArticles() {
        List<RadiotArticleDBEntity> radiotArticleList = new ArrayList<>();
        JSONArray jsonArticles = jsonConsumer.getJsonArray(radiotUrlBuilder.buildNewsUrl(100));
        jsonArticles.forEach(article -> {
            JSONObject jsonArticle = (JSONObject) article;
            RadiotArticleDBEntity dbArticle = new RadiotArticleDBEntity();
            dbArticle.setAuthor(jsonArticle.getString("author"));
            dbArticle.setComments(jsonArticle.getLong("comments"));
            dbArticle.setContent(jsonArticle.getString("content"));
            dbArticle.setFeed(jsonArticle.getString("feed"));
            dbArticle.setLastUpdated(Timestamp.from(Instant.now()));
            dbArticle.setLikes(jsonArticle.getLong("likes"));
            dbArticle.setLink(jsonArticle.getString("link"));
            dbArticle.setMainPicture(jsonArticle.getString("pic"));
            dbArticle.setOriginalTime(Timestamp.from(Instant.now()));
            dbArticle.setRadiotTime(Timestamp.from(Instant.now()));
            dbArticle.setSlug(jsonArticle.getString("slug"));
            dbArticle.setSnippet(jsonArticle.getString("snippet"));
            dbArticle.setTitle(jsonArticle.getString("title"));
            dbArticle = radiotArticleRepository.save(dbArticle);
            radiotArticleList.add(dbArticle);
        });
        return radiotArticleList;
    }
}
