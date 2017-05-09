package model;

import com.google.gson.Gson;
import entity.Airline;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 *
 * @author joaci
 */
public class UrlGetter {

    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    Gson gson = new Gson();

    List<String> list = new ArrayList();

    
    // to and from
    public UrlGetter(String dest, String to, String date, String passengers) {
        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/" + dest + "/" + to + "/" + date + "/" + passengers);
        list.add("https://airline.skaarup.io/api/flights/" + dest + "/" + to + "/" + date + "/" + passengers); 
    }

    
    // to
    public UrlGetter(String dest, String date, String passengers) {
        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/" + dest + "/" + date + "/" + passengers);
        list.add("https://airline.skaarup.io/api/flights/" + dest + "/" + date + "/" + passengers);
    }

    public List<Airline> getData() {
        List<String> newList = list.stream()
                .map(url -> executor.submit(new URLHandler(url, "GET")))
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                        return "";
                    }
                }).parallel()
                .collect(Collectors.toList());
        List<Airline> airlines = new ArrayList();
        newList.forEach(airline -> airlines.add(gson.fromJson(airline, Airline.class)));
        return airlines;

    }

}
