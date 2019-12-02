package mg.news.service;

import mg.news.entity.RadiotPodcast;
import mg.news.entity.RadiotPodcastTimeLabel;
import mg.news.mapper.RadiotPodcastMapper;
import mg.news.dto.RadiotPodcastDto;
import mg.news.repository.RadiotPodcastRepository;
import mg.news.repository.RadiotPodcastTimeLabelRepository;
import mg.news.util.RadiotUrlBuilder;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RadiotPodcastService {

    @Autowired
    private JSONConsumer jsonConsumer;
    @Autowired
    private JSONHelper jsonHelper;
    @Autowired
    private RadiotUrlBuilder radiotUrlBuilder;
    @Autowired
    private RadiotPodcastRepository radiotPodcastRepository;
    @Autowired
    private RadiotPodcastTimeLabelRepository radiotPodcastTimeLabelRepository;

    public List<RadiotPodcastDto> getRadiotPodcasts() {
        List<RadiotPodcast> podcasts = new ArrayList<>();
        if (radiotPodcastRepository.findAll().iterator().hasNext()) {
            radiotPodcastRepository.findAll().forEach(podcasts::add);
        } else {
            podcasts = updateRadiotPodcasts();
        }
        return podcasts.stream()
                .map(RadiotPodcastMapper.INSTANCE::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<RadiotPodcast> updateRadiotPodcasts() {
        radiotPodcastRepository.deleteAll();
        return saveRadiotPodcasts(jsonConsumer.getJsonArray(radiotUrlBuilder.buildPodcastUrl()));
    }

    private List<RadiotPodcast> saveRadiotPodcasts(JSONArray json) {
        List<RadiotPodcast> result = new ArrayList<>();
        json.forEach(item -> {
            RadiotPodcast radiotPodcast = new RadiotPodcast();
            JSONObject jsonItem = (JSONObject) item;
            Set<RadiotPodcastTimeLabel> timeLabels = null;
            radiotPodcast.setAudioUrl(jsonHelper.getString(jsonItem, "audio_url"));
            radiotPodcast.setBody(jsonHelper.getString(jsonItem, "body"));
            radiotPodcast.setImage(jsonHelper.getString(jsonItem, "image"));
            radiotPodcast.setShowNotes(jsonHelper.getString(jsonItem, "show_notes"));
            radiotPodcast.setTitle(jsonHelper.getString(jsonItem, "title"));
            radiotPodcast.setUrl(jsonHelper.getString(jsonItem, "url"));
            radiotPodcast.setDate(Timestamp.from(Instant.now()));
            radiotPodcast = radiotPodcastRepository.save(radiotPodcast);
            timeLabels = saveRadiotPodcastTimeLabels(jsonHelper.getJSONArray(jsonItem, "time_labels"), radiotPodcast);
            radiotPodcast.setTimeLabels(timeLabels);
            result.add(radiotPodcastRepository.save(radiotPodcast));
        });
        return result;
    }

    private Set<RadiotPodcastTimeLabel> saveRadiotPodcastTimeLabels(JSONArray json, RadiotPodcast podcast) {
        Set<RadiotPodcastTimeLabel> result = new HashSet<>();
        json.forEach(item -> {
            JSONObject jsonItem = (JSONObject) item;
            RadiotPodcastTimeLabel timeLabel = new RadiotPodcastTimeLabel();
            timeLabel.setDuration(jsonHelper.getLong(jsonItem, "duration"));
            timeLabel.setTopic(jsonHelper.getString(jsonItem, "topic"));
            timeLabel.setTime(Timestamp.from(Instant.now()));
            timeLabel.setPodcast(podcast);
            result.add(radiotPodcastTimeLabelRepository.save(timeLabel));
        });
        return result;
    }
}
