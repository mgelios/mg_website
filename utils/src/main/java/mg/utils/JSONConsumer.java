package mg.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public interface JSONConsumer {

    JSONObject getJsonObject(String url);

    JSONObject getJsonObject(String url, Map<String, String> headers);

    JSONArray getJsonArray(String url);

    JSONArray getJsonArray(String url, Map<String, String> headers);
}
