package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FlightReservation implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    
    private String airline;
    
    @OneToOne
    private Reservation reservation;

    public FlightReservation() {
    }

    public FlightReservation(Reservation reservation) {
        this.airline = "AirWonDo";
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

    @Override
    public String toString() {
        return "FlightReservation{" + "airline=" + airline + ", reservation=" + reservation + '}';
    }


}
