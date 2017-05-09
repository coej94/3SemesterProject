package model;

import entity.FlightReservation;

public class ReservationHandler {
    public void requestReservation(FlightReservation fr) {
        String url ="";
        switch (fr.getAirline()) {
            case "AngularJS Airline":
                url = "http://airline-plaul.rhcloud.com/api/reservation/";
                break;
            case "JENS air":
                url = "https://airline.skaarup.io/api/reservation/";
                break;
        }
        System.out.println(new URLHandler(url,"POST",fr.getReservation().toString()));
    }
}
