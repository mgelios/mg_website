package mg.news.services;

import mg.news.converter.RadiotPodcastDTOToEntity;
import mg.news.converter.RadiotPodcastEntityToDTO;
import mg.news.dbentities.RadiotPodcastDBEntity;
import mg.news.dbentities.RadiotPodcastTimeLabelDBEntity;
import mg.news.models.RadiotPodcast;
import mg.news.repositories.RadiotPodcastRepository;
import mg.news.repositories.RadiotPodcastTimeLabelRepository;
import mg.news.utils.RadiotUrlBuilder;
import mg.utils.JSONConsumer;
import mg.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RadiotPodcastService {

    @Autowired
    JSONConsumer jsonConsumer;
    @Autowired
    JSONHelper jsonHelper;
    @Autowired
    RadiotUrlBuilder radiotUrlBuilder;
    @Autowired
    RadiotPodcastRepository radiotPodcastRepository;
    @Autowired
    RadiotPodcastTimeLabelRepository radiotPodcastTimeLabelRepository;
    @Autowired
    RadiotPodcastDTOToEntity radiotPodcastDTOToEntity;
    @Autowired
    RadiotPodcastEntityToDTO radiotPodcastEntityToDTO;

    public List<RadiotPodcast> getRadiotPodcasts() {
        List<RadiotPodcastDBEntity> podcasts = new ArrayList<>();
        if (radiotPodcastRepository.findAll().iterator().hasNext()) {
            radiotPodcastRepository.findAll().forEach(podcasts::add);
        } else {
            updateRadiotPodcasts();
            radiotPodcastRepository.findAll().forEach(podcasts::add);
        }
        return podcasts.stream()
                .map(radiotPodcastEntityToDTO::convert)
                .collect(Collectors.toList());
    }

    public void updateRadiotPodcasts() {
        radiotPodcastRepository.deleteAll();
        saveRadiotPodcasts(jsonConsumer.getJsonArray(radiotUrlBuilder.buildPodcastUrl()));
    }

    private void saveRadiotPodcasts(JSONArray json) {
        json.forEach(item -> {
            RadiotPodcastDBEntity radiotPodcast = new RadiotPodcastDBEntity();
            radiotPodcast.setAudioUrl(((JSONObject) item).getString("audio_url"));
            radiotPodcast.setBody(((JSONObject) item).getString("body"));
            radiotPodcast.setDate(Timestamp.from(Instant.now()));
            radiotPodcast.setImage(((JSONObject) item).getString("image"));
            radiotPodcast.setShowNotes(((JSONObject) item).getString("show_notes"));
            radiotPodcast.setTitle(((JSONObject) item).getString("title"));
            radiotPodcast.setUrl(((JSONObject) item).getString("url"));
            radiotPodcast = radiotPodcastRepository.save(radiotPodcast);
            saveRadiotPodcastTimeLabels(((JSONObject) item).getJSONArray("time_labels"), radiotPodcast);
        });
    }

    private void saveRadiotPodcastTimeLabels(JSONArray json, RadiotPodcastDBEntity podcast) {
        json.forEach(item -> {
            RadiotPodcastTimeLabelDBEntity timeLabel = new RadiotPodcastTimeLabelDBEntity();
            timeLabel.setDuration(jsonHelper.getLong((JSONObject) item, "duration"));
            timeLabel.setTime(Timestamp.from(Instant.now()));
            timeLabel.setTopic(jsonHelper.getString((JSONObject) item, "topic"));
            timeLabel.setPodcast(podcast);
            radiotPodcastTimeLabelRepository.save(timeLabel);
        });
    }
}
