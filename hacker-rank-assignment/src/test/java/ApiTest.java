import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiTest {

    @Test
    public void firstTest(){
        assertTrue(true);
    }

    @Test
    public void getMethod() throws IOException {

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet  request = new HttpGet("http://10.42.19.233:8080/api/clusters/DpClusterStag/consumer-groups/");
        CloseableHttpResponse response = closeableHttpClient.execute(request);

        int code = response.getStatusLine().getStatusCode();
        assertEquals(200,code);

    }
}
