package model;

import entity.Flight;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomData {

    private String flightID, date, origin, destination, flightNumber;
    private int numberOfSeats, traveltime;
    private float totalPrice;
    private Random random = new Random();

    public RandomData() {
    }

    public Flight getFlight() {
        return new Flight(getFlightID(), getDate(), getOrigin(), getDestination(), getFlightNumber(), getNumberOfSeats(), getTraveltime(), getTotalPrice());
    }

    public String getFlightID() {
        int random1 = random.nextInt(900000000) + 100000000;
        int random2 = random.nextInt(9000) + 1000;
        return "1111-" + random1 + random2;
    }

    public String getDate() {
        int year = random.nextInt(3) + 7;
        int month = random.nextInt(4) + 6;
        int d = random.nextInt(29) + 1;
        int ran = random.nextInt(13) + 6;

        String day;
        if (d < 10) {
            day = "0" + d;
        } else {
            day = "" + d;
        }

        String t;
        if (ran < 10) {
            t = "0" + ran;
        } else {
            t = "" + ran;
        }

        return "201" + year + "-0" + month + "-" + day + "T" + t + ":00:00.000Z";
    }

    public String getOrigin() {
        List<String> origins = new ArrayList();
        origins.add("SXF");
        origins.add("ATL");
        origins.add("PEK");
        origins.add("DXB");
        origins.add("LAX");
        origins.add("HND");
        origins.add("LHR");
        origins.add("ORD");
        origins.add("HKG");
        origins.add("PVG");
        origins.add("CPH");
        origins.add("CDG");
        origins.add("DFW");
        origins.add("JFK");
        origins.add("AMS");
        origins.add("FAN");
        origins.add("IST");
        origins.add("CAN");
        origins.add("DEL");
        origins.add("SYD");
        origins.add("KMG");

        return origins.get(random.nextInt(origins.size()));
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

        return destinations.get(random.nextInt(destinations.size()));
    }

    public String getFlightNumber() {
        int number = random.nextInt(9000) + 1000;

        return getDestination() + number;
    }

    public int getNumberOfSeats() {
        return random.nextInt(5) + 1;
    }

    public int getTraveltime() {
        int time1 = random.nextInt(5) + 1;
        int time2 = random.nextInt(6);

        String finalTime = "" + time1 + time2;
        if (Integer.parseInt(finalTime) < 35) {
            finalTime += "0";
        }

        return Integer.parseInt(finalTime);
    }

    public float getTotalPrice() {
        float price = random.nextInt(451) + 50;
        float finalPrice = price * getNumberOfSeats();

        return finalPrice;
    }
}
