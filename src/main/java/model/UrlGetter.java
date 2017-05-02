package model;

import com.google.gson.Gson;
import entity.Airline;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author joaci
 */
public class UrlGetter {

    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    Gson gson = new Gson();

    public List<Airline> getData(String requestMethod, String dest, String date, String passengers
    ) {
        List<String> list = new ArrayList();
        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/"+dest+"/"+date+"/"+passengers);
//        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-05-06T00:00:00.000Z/1"); // Andre flyselskaber
//        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-05-07T00:00:00.000Z/1");
//        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-05-08T00:00:00.000Z/1");
//        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-05-09T00:00:00.000Z/1");
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
