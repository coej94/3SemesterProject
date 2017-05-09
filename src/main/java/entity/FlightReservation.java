package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Asger
 */
@Entity
public class FlightReservation implements Serializable {

    @Id
    private String airline;
    private Reservation reservation;
    
    public FlightReservation() {
    }

    public FlightReservation(String airline, Reservation reservation) {
        this.airline = airline;
        this.reservation = reservation;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}