package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/**
 *
 * @author joaci
 */
public class URLHandler implements Callable<String> {

    private final String URL;
    private HttpURLConnection CONNECTION;
    private final String REQUESTMETHOD;
    private String output;

    public URLHandler(String url, String requestMethod) {
        this.URL = url;
        this.REQUESTMETHOD = requestMethod;
    }

    @Override
    public String call() throws Exception {
        return getJson();
    }

    public String getJson() throws IOException {
        try {
            CONNECTION = (HttpURLConnection) new URL(URL).openConnection();
            CONNECTION.setRequestMethod(REQUESTMETHOD);
            CONNECTION.setRequestProperty("Accept", "application/json");
            if (CONNECTION.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + CONNECTION.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((CONNECTION.getInputStream())));
            String output;
            String result = "";
            while ((output = br.readLine()) != null) {
                result += output;
            }
            CONNECTION.disconnect();
            return result;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
