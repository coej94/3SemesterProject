package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline implements Serializable {

    public Airline() {

    }

    @Id
    String airline;
    List<Flight> flights;

    public Airline(int airlineID, String airline, List<Flight> flights) {
        this.airline = airline;
        this.flights = flights;
    }

    @Override
    public String toString() {
        return airline + flights;
    }

}
