package model;

import entity.Airline;
import entity.Flight;
import entity.Reservation;
import entity.ReservationResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {

    private Random random = new Random();

    public Airline getAirline(String origin, String date, int numberOfSeats) {
        Airline airWonDo = new Airline();
        int numberOfFlights = random.nextInt(5) + 1;

        for (int i = 0; i < numberOfFlights; i++) {
            String destination = getDestination();
            airWonDo.addFlight(new Flight(getFlightID(), getFlightNumber(destination), getDate(date), numberOfSeats, getTotalPrice(numberOfSeats), getTravelTime(), origin, destination));
        }

        return airWonDo;
    }

    public Airline getAirline(String origin, String destination, String date, int numberOfSeats) {
        Airline airWonDo = new Airline();
        int numberOfFlights = random.nextInt(5) + 1;

        for (int i = 0; i < numberOfFlights; i++) {
            airWonDo.addFlight(new Flight(getFlightID(), getFlightNumber(destination), getDate(date), numberOfSeats, getTotalPrice(numberOfSeats), getTravelTime(), origin, destination));
        }

        return airWonDo;
    }

    public ReservationResponse getReservationResponse(Flight flight, Reservation reservation) {
        return new ReservationResponse(flight.getFlightNumber(), flight.getOrigin(), flight.getDestination(), flight.getDate(), flight.getTraveltime(), reservation.getNumberOfSeats(), reservation.getReserveeName(), reservation.getPassengers());
    }

    public String getFlightID() {
        int random1 = random.nextInt(900000000) + 100000000;
        int random2 = random.nextInt(9000) + 1000;
        return "1111-" + random1 + random2;
    }

    public String getDate(String date) {
        String yearMonthDay = date.substring(0, 11);
        int hour = random.nextInt(13) + 6;
        String time = "" + hour;

        if (hour < 10) {
            time = "0" + hour;
        }

        return yearMonthDay + time + ":00:00.000Z";
    }

    public String getDestination() {
        List<String> destinations = new ArrayList();
        destinations.add("SXF");
        destinations.add("ATL");
        destinations.add("PEK");
        destinations.add("DXB");
        destinations.add("LAX");
        destinations.add("HND");
        destinations.add("LHR");
        destinations.add("ORD");
        destinations.add("HKG");
        destinations.add("PVG");
        destinations.add("CPH");
        destinations.add("CDG");
        destinations.add("DFW");
        destinations.add("JFK");
        destinations.add("AMS");
        destinations.add("FAN");
        destinations.add("IST");
        destinations.add("CAN");
        destinations.add("DEL");
        destinations.add("SYD");
        destinations.add("KMG");
        destinations.add("BCN");
        destinations.add("STN");

        return destinations.get(random.nextInt(destinations.size()));
    }

    public String getFlightNumber(String destination) {
        int number = random.nextInt(9000) + 1000;

        return destination + number;
    }

    public int getTravelTime() {
        int time1 = random.nextInt(5) + 1;
        int time2 = random.nextInt(6);

        String finalTime = "" + time1 + time2;
        if (Integer.parseInt(finalTime) < 35) {
            finalTime += "0";
        }

        return Integer.parseInt(finalTime);
    }

    public float getTotalPrice(int numberOfSeats) {
        float price = random.nextInt(451) + 50;
        float finalPrice = price * numberOfSeats;

        return finalPrice;
    }
}
