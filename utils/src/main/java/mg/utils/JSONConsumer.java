package mg.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public interface JSONConsumer {

    JSONObject getJsonObject(String url);

    JSONArray getJsonArray(String url);
}
