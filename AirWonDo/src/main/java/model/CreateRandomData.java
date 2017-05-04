package model;

public class CreateRandomData {

    private String flightID, date, origin, destination, flightNumber;
    private int numberOfSeats, traveltime;
    private float totalPrice;

    public CreateRandomData() {
    }

    public CreateRandomData(String flightID, String date, String origin, String destination, String flightNumber, int numberOfSeats, int traveltime, float totalPrice) {
        this.flightID = flightID;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.numberOfSeats = numberOfSeats;
        this.traveltime = traveltime;
        this.totalPrice = totalPrice;
    }

    public String getFlightID() {
        return "2215-1495540800000";
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getDate() {
        return "2017-05-23T08:00:00.000Z";
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrigin() {
        return "SXF";
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return "CPH";
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return "COL2215";
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getNumberOfSeats() {
        return 1;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getTraveltime() {
        return 60;
    }

    public void setTraveltime(int traveltime) {
        this.traveltime = traveltime;
    }

    public float getTotalPrice() {
        return 85;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

}
