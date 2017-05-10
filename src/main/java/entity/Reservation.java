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
    private String reserveeName, reservePhone, reserveeEmail;
    @OneToMany
    private List<Passenger> passengers;
    
    public Reservation(){
        
    }

    public Reservation(String flightID, int numberOfSeats, String reserveeName, String reservePhone, String reserveeEmail, List<Passenger> passengers) {
        this.flightID = flightID;
        this.numberOfSeats = numberOfSeats;
        this.reserveeName = reserveeName;
        this.reservePhone = reservePhone;
        this.reserveeEmail = reserveeEmail;
        this.passengers = passengers;
    }

    public String getFlightId() {
        return flightID;
    }

    public void setFlightId(String flightID) {
        this.flightID = flightID;
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

    public void setReserveName(String reserveeName) {
        this.reserveeName = reserveeName;
    }

    public String getReservePhone() {
        return reservePhone;
    }

    public void setReservePhone(String reservePhone) {
        this.reservePhone = reservePhone;
    }

    public String getReserveEmail() {
        return reserveeEmail;
    }

    public void setReserveEmail(String reserveeEmail) {
        this.reserveeEmail = reserveeEmail;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "{\"flightID\" : \""+flightID+"\", \"numberOfSeats\": \""+numberOfSeats+"\",\"reserveeName\": \""+reserveeName+"\",\"reservePhone\": \""+reservePhone+"\",\"reserveeEmail\": \""+reserveeEmail+"\",\"passengers\":" +passengers.toString() +"}";
    }
    
}