package http;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

class HttpRequestBasicTest {

    @Test
    public void makeBareHttpRequest() throws IOException {
        final URL url = new URL("http", "www.google.com", "/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        final InputStream responseInputStream = urlConnection.getInputStream();
        final int responseCode = urlConnection.getResponseCode();

        parseResponseData(responseInputStream);

        responseInputStream.close();

        assertEquals(200, responseCode);
    }

    @Test
    public void makeApacheHttpClientRequest() throws IOException {
        final CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.google.com");
        HttpResponse httpResponse = client.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        HttpEntity entity = httpResponse.getEntity();
        InputStream responseInputStream = entity.getContent();
        String responseData = parseResponseData(responseInputStream);
        System.out.println(responseData);

        assertEquals(200, statusCode);
    }

    private String parseResponseData(InputStream responseInputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(responseInputStream, Charset.forName("UTF-8"));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        bufferedReader.lines().forEach(line -> stringBuilder.append(line));

        return stringBuilder.toString();
    }
}
