package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Asger
 */
@Entity
public class FlightReservation implements Serializable {

    @Id
    private String airline;
    
    private String userName;

    @OneToOne
    private Reservation reservation;

    public FlightReservation() {
    }

    public FlightReservation(String airline, Reservation reservation) {
        this.airline = airline;
        this.reservation = reservation;
    }

    public FlightReservation(String airline, String userName, Reservation reservation) {
        this.airline = airline;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "FlightReservation{" + "airline=" + airline + ", userName=" + userName + ", reservation=" + reservation + '}';
    }


}
