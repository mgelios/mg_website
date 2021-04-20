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
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RadiotPodcastService {

    private static final long PODCAST_EXPIRATION_THRESHOLD_IN_HOURS = 6;

    private final RadiotPodcastRepository radiotPodcastRepository;
    private final RadiotPodcastTimeLabelRepository radiotPodcastTimeLabelRepository;
    private final RadiotExternalApiService radiotExternalApiService;
    private final JSONHelper jsonHelper;

    public List<RadiotPodcast> getRadiotPodcasts() {
        RadiotPodcast podcast = radiotPodcastRepository.findFirstByDate().orElse(null);
        if (podcast == null || isPodcastHasExpired(podcast)) {
            return updateRadiotPodcasts();
        }
        return radiotPodcastRepository.findAll();
    }

    private boolean isPodcastHasExpired(RadiotPodcast podcast) {
        long hours = podcast.getDate().until(OffsetDateTime.now(), ChronoUnit.HOURS);
        return hours > PODCAST_EXPIRATION_THRESHOLD_IN_HOURS;
    }

    public List<RadiotPodcast> updateRadiotPodcasts() {
        JSONArray json = radiotExternalApiService.fetchPodcasts();
        if (json != null) {
            return saveRadiotPodcasts(json);
        }
        return radiotPodcastRepository.findAll();
    }

    private List<RadiotPodcast> saveRadiotPodcasts(JSONArray json) {
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
                    .date(OffsetDateTime.now())
                    .build();
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
            RadiotPodcastTimeLabel timeLabel = RadiotPodcastTimeLabel.builder()
                    .duration(jsonHelper.getLong(jsonItem, "duration"))
                    .topic(jsonHelper.getString(jsonItem, "topic"))
                    .time(Timestamp.from(Instant.now()))
                    .podcast(podcast)
                    .build();
            result.add(radiotPodcastTimeLabelRepository.save(timeLabel));
        });
        return result;
    }
}
