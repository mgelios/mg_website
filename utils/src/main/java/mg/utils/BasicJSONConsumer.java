package mg.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class BasicJSONConsumer implements JSONConsumer {

    public JSONObject getJsonObject(String url) {
        return getJsonObject(url, null);
    }

    public JSONObject getJsonObject(String url, Map<String, String> headers) {
        try {
            return new JSONObject(getJsonAsString(url, headers));
        } catch (JSONException e) {
            log.error("JSON Exception occurred");
            return null;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public JSONArray getJsonArray(String url) {
        return getJsonArray(url, null);
    }

    public JSONArray getJsonArray(String url, Map<String, String> headers) {
        try {
            return new JSONArray(getJsonAsString(url, headers));
        } catch (JSONException e) {
            log.error("JSON Exception occurred");
            return null;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    private String getJsonAsString(String url, Map<String, String> headers) {
        String result = "";
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(url);
            headers.forEach(getRequest::addHeader);
            HttpResponse response = client.execute(getRequest);
            result = EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e){
            log.error("Client protocol exception");
        } catch (IOException e){
            log.error("IO exception");
        }
        return result;
    }
}
