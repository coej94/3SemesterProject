package model;

import entity.Flight;
import java.util.Random;

public class RandomData {

    private Random random = new Random();

    public Flight getFlight(String origin, String destination, String date, int numberOfSeats) {
        return new Flight(getFlightID(), getDate(date), origin, destination, getFlightNumber(destination), numberOfSeats, getTravelTime(), getTotalPrice(numberOfSeats));
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
