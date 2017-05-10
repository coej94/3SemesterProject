package model;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class URLHandlerPost {

    private final  String URL;
    private HttpURLConnection CONNECTION;
    private final String json;

    public URLHandlerPost(String URL, String json) {
        this.URL = URL;
        this.json = json;
    }

    public String post() {
        try {
            System.out.println(URL);
            CONNECTION = (HttpURLConnection) new URL(URL).openConnection();
            CONNECTION.setRequestMethod("POST");
            CONNECTION.setRequestProperty("Content-Type", "application/json");
            CONNECTION.setRequestProperty("Accept", "application/json");
            CONNECTION.setRequestProperty("Method", "POST");
            CONNECTION.setDoOutput(true);
            System.out.println(json);
            //PrintWriter pw = new PrintWriter(CONNECTION.getOutputStream());
            try(OutputStream os = CONNECTION.getOutputStream()) {
                os.write(json.getBytes("UTF-8"));
            }
            int HttpResult = CONNECTION.getResponseCode();
            InputStreamReader is = HttpResult < 400 ? new InputStreamReader(CONNECTION.getInputStream(), "utf-8") : new InputStreamReader(CONNECTION.getErrorStream(), "utf-8");
            Scanner responseReader = new Scanner(is);
            String response = "";
            while(responseReader.hasNext()) {
                response += responseReader.nextLine()+System.getProperty("line.separator");
            }
            System.out.println(response);
            System.out.println(CONNECTION.getResponseCode());
            System.out.println(CONNECTION.getResponseMessage());
            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "{\"URLHandlerPostSucces\":\"false\"}";
    }
}
