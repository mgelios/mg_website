package mg.weather;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@WireMockTest(httpPort = 9292)
public class BasicWireMockTest {

    @Test
    public void exampleTest() throws IOException, ClientProtocolException {
        stubFor(get("/my/resource")
                .willReturn(ok()
                        .withBody("<response>SUCCESS</response>")));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:9292/my/resource");
        HttpResponse httpResponse = httpClient.execute(request);

        verify(getRequestedFor(urlPathEqualTo("/my/resource")));
    }
}
