package mg.news.services;

import mg.news.dbentities.RadiotPodcastDBEntity;
import mg.news.repositories.RadiotPodcastRepository;
import mg.news.repositories.RadiotPodcastTimeLabelRepository;
import mg.news.utils.RadiotUrlBuilder;
import mg.utils.JSONConsumer;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RadiotPodcastService {

    @Autowired
    JSONConsumer jsonConsumer;
    @Autowired
    RadiotUrlBuilder radiotUrlBuilder;
    @Autowired
    RadiotPodcastRepository radiotPodcastRepository;
    @Autowired
    RadiotPodcastTimeLabelRepository radiotPodcastTimeLabelRepository;

    public void updateRadiotPodcasts() {
        radiotPodcastRepository.deleteAll();
        saveRadiotPodcasts(jsonConsumer.getJsonArray(radiotUrlBuilder.buildPodcastUrl()));
    }

    private void saveRadiotPodcasts(JSONArray json) {
        RadiotPodcastDBEntity radiotPodcast = new RadiotPodcastDBEntity();


    }
}
