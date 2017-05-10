package model;

import entity.FlightReservation;

public class ReservationHandler {

    public String requestReservation(FlightReservation fr) {
        String url = "";
        switch (fr.getAirline()) {
            case "AngularJS Airline":
                url = "http://airline-plaul.rhcloud.com/api/flightreservation/";
                break;
            case "JENS air":
                url = "https://airline.skaarup.io/api/flightreservation/";
                break;
            case "AirWonDo":
                url = "https://vetterlain.dk/AirWonDo/api/flightreservation/";
                break;
        }

        try {
            return new URLHandlerPost(url, fr.getReservation().toString()).post();
            // URLHandler urlh = new URLHandler(url, "POST", fr.getReservation().toString());
            //System.out.println("her er jeg: " + urlh.call());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "{\"ReservationHandlerSucces\":\"false\"}";
    }
}
