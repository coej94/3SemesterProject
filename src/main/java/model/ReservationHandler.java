package model;

import entity.FlightReservation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

public class ReservationHandler {
    
    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    
    public void requestReservation(FlightReservation fr) {
        List<String> list = new ArrayList();
        switch (fr.getAirline()) {
            case "AngularJS Airline":
                list.add("http://airline-plaul.rhcloud.com/api/reservation/" + fr.getReservation().getFlightId());
                break;
            case "JENS air":
                list.add("https://airline.skaarup.io/api/reservation/" + fr.getReservation().getFlightId());
                break;
        }
        List<String> newList = list.stream()
                .map(url -> executor.submit(new URLHandler(url, "POST", fr.getReservation().toString())))
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                        return "";
                    }
                }).parallel()
                .collect(Collectors.toList());
        System.out.println("size: " + newList.size());
        //System.out.println(newList.get(0));
    }
    
}
