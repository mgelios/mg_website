package mg.news.service;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class RadiotPodcastService {

    private final JSONConsumer jsonConsumer;
    private final JSONHelper jsonHelper;
    private final RadiotUrlBuilder radiotUrlBuilder;
    private final RadiotPodcastRepository radiotPodcastRepository;
    private final RadiotPodcastTimeLabelRepository radiotPodcastTimeLabelRepository;

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
        if (json != null) {
            List<RadiotPodcast> result = new ArrayList<>();
            json.forEach(item -> {
                JSONObject jsonItem = (JSONObject) item;
                Set<RadiotPodcastTimeLabel> timeLabels = null;
                RadiotPodcast radiotPodcast = RadiotPodcast.builder()
                        .audioUrl(jsonHelper.getString(jsonItem, "audio_url"))
                        .body(jsonHelper.getString(jsonItem, "body"))
                        .image(jsonHelper.getString(jsonItem, "image"))
                        .showNotes(jsonHelper.getString(jsonItem, "show_notes"))
                        .title(jsonHelper.getString(jsonItem, "title"))
                        .url(jsonHelper.getString(jsonItem, "url"))
                        .date(Timestamp.from(Instant.now()))
                        .build();
                radiotPodcast = radiotPodcastRepository.save(radiotPodcast);
                timeLabels = saveRadiotPodcastTimeLabels(jsonHelper.getJSONArray(jsonItem, "time_labels"), radiotPodcast);
                radiotPodcast.setTimeLabels(timeLabels);
                result.add(radiotPodcastRepository.save(radiotPodcast));
            });
            return result;
        } else {
            return null;
        }
    }

    private Set<RadiotPodcastTimeLabel> saveRadiotPodcastTimeLabels(JSONArray json, RadiotPodcast podcast) {
        if (json != null) {
            Set<RadiotPodcastTimeLabel> result = new HashSet<>();
            json.forEach(item -> {
                JSONObject jsonItem = (JSONObject) item;
                RadiotPodcastTimeLabel timeLabel = RadiotPodcastTimeLabel.builder()
                        .duration(jsonHelper.getLong(jsonItem, "duration"))
                        .topic(jsonHelper.getString(jsonItem, "topic"))
                        .time(Timestamp.from(Instant.now()))
                        .podcast(podcast)
                        .build();
                result.add(radiotPodcastTimeLabelRepository.save(timeLabel));
            });
            return result;
        } else {
            return null;
        }
    }
}
