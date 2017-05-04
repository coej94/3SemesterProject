package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight implements Serializable {

    @Id
    String flightID;
    String date, origin, destination, flightNumber;
    int numberOfSeats, traveltime;
    float totalPrice;

    public Flight() {

    }

    public Flight(String flightID, String date, String origin, String destination, String flightNumber, int numberOfSeats, int traveltime, float totalPrice) {
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
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getTraveltime() {
        return traveltime;
    }

    public void setTraveltime(int traveltime) {
        this.traveltime = traveltime;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

}
