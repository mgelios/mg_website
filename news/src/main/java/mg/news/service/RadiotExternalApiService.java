package mg.news.service;

import lombok.AllArgsConstructor;
import mg.news.util.RadiotUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RadiotExternalApiService {

    private static final int NUMBER_OF_ARTICLES_TO_FETCH = 100;

    private final JSONConsumer jsonConsumer;
    private final RadiotUrlBuilder radiotUrlBuilder;

    public JSONArray fetchArticles() {
        return jsonConsumer.getJsonArray(radiotUrlBuilder.buildNewsUrl(NUMBER_OF_ARTICLES_TO_FETCH));
    }

    public JSONArray fetchPodcasts() {
        return jsonConsumer.getJsonArray(radiotUrlBuilder.buildPodcastUrl());
    }
}
