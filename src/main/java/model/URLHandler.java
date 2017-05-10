package model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class URLHandler implements Callable<String> {

    private final String URL;
    private HttpURLConnection CONNECTION;
    private final String REQUESTMETHOD;
    private String urlBody;

    public URLHandler(String url, String requestMethod) {
        this.URL = url;
        this.REQUESTMETHOD = requestMethod;
    }

    public URLHandler(String URL, String REQUESTMETHOD, String urlBody) {
        this.URL = URL;
        this.REQUESTMETHOD = REQUESTMETHOD;
        this.urlBody = urlBody;
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
            if (REQUESTMETHOD == "POST") {
                CONNECTION.setUseCaches(false);
                CONNECTION.setDoInput(true);
                CONNECTION.setDoOutput(true);
                try (DataOutputStream wr = new DataOutputStream(
                        CONNECTION.getOutputStream())) {
                    wr.writeBytes(urlBody);
                    wr.flush();
                }
            }
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
