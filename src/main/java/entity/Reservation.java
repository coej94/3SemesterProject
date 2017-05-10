package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reservation implements Serializable{

    @Id
    private String flightID;
    private int numberOfSeats;
    private String reserveeName, reservePhone, reserveEmail;
    @OneToMany
    private List<Passenger> passengers;
    
    public Reservation(){
        
    }

    public Reservation(String flightId, int numberOfSeats, String reserveName, String reservePhone, String reserveEmail, List<Passenger> passengers) {
        this.flightID = flightId;
        this.numberOfSeats = numberOfSeats;
        this.reserveeName = reserveName;
        this.reservePhone = reservePhone;
        this.reserveEmail = reserveEmail;
        this.passengers = passengers;
    }

    public String getFlightId() {
        return flightID;
    }

    public void setFlightId(String flightId) {
        this.flightID = flightId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReserveName() {
        return reserveeName;
    }

    public void setReserveName(String reserveName) {
        this.reserveeName = reserveName;
    }

    public String getReservePhone() {
        return reservePhone;
    }

    public void setReservePhone(String reservePhone) {
        this.reservePhone = reservePhone;
    }

    public String getReserveEmail() {
        return reserveEmail;
    }

    public void setReserveEmail(String reserveEmail) {
        this.reserveEmail = reserveEmail;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "{\"flightId\" : \""+flightID+"\", \"numberOfSeats\": \""+numberOfSeats+"\",\"reserveName\": \""+reserveeName+"\",\"reservePhone\": \""+reservePhone+"\",\"reserveEmail\": \""+reserveEmail+"\",\"passengers\":" +passengers.toString() +"}";
    }
    
}