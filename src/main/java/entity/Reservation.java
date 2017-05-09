package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reservation {

    @Id
    private String FlightId;
    private String ReserveName, ReservePhone, ReserveEmail;
    @OneToMany
    private List<Passenger> passengers;

    public Reservation(String FlightId, String ReserveName, String ReservePhone, String ReserveEmail, List<Passenger> passengers) {
        this.FlightId = FlightId;
        this.ReserveName = ReserveName;
        this.ReservePhone = ReservePhone;
        this.ReserveEmail = ReserveEmail;
        this.passengers = passengers;
    }

    public String getReserveName() {
        return ReserveName;
    }

    public void setReserveName(String ReserveName) {
        this.ReserveName = ReserveName;
    }

    public String getReservePhone() {
        return ReservePhone;
    }

    public void setReservePhone(String ReservePhone) {
        this.ReservePhone = ReservePhone;
    }

    public String getReserveEmail() {
        return ReserveEmail;
    }

    public void setReserveEmail(String ReserveEmail) {
        this.ReserveEmail = ReserveEmail;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
    
    public String getFlightId() {
        return FlightId;
    }

    public void setFlightId(String FlightId) {
        this.FlightId = FlightId;
    }
}
