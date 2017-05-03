/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Staal
 */
@Entity
public class Flight implements Serializable {

    public Flight() {

    }

    @Id
    String flightID;
    String date, origin, destination, flightNumber;
    int numberOfSeats, traveltime;
    float totalPrice;

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
}
