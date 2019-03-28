package mg.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class BasicJSONConsumer implements JSONConsumer {

    public JSONObject getJsonObject(String url) {
        return new JSONObject(getJsonAsString(url));
    }

    public JSONArray getJsonArray(String url) {
        return new JSONArray(getJsonAsString(url));
    }

    private String getJsonAsString(String url) {
        String result = "";
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url);
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e){
            log.error(e.getMessage());
        } catch (IOException e){
            log.error(e.getMessage());
        }
        return result;
    }
}
