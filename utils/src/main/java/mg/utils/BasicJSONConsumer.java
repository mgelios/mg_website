package mg.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BasicJSONConsumer implements JSONConsumer{

    public JSONObject getJson(String url){
        JSONObject result = null;
        try {
            String resultAsString = null;
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url);
            HttpResponse response = client.execute(get);
            resultAsString = EntityUtils.toString(response.getEntity());
            result  = new JSONObject(resultAsString);
        } catch (ClientProtocolException e){
            //TODO: logging errors
        } catch (IOException e){
            //TODO: logging errors
        }
        return result;
    }

}
