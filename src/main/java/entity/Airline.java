package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airline implements Serializable {

    public Airline() {

    }

    @Id
    private String airline;
    @OneToMany
    private List<Flight> flights;

    public Airline(String airline, List<Flight> flights) {
        this.airline = airline;
        this.flights = flights;
    }

    
    public void addFlight(Flight f){
        flights.add(f);
    }

    /**
     * @return the flights
     */
    public List<Flight> getFlights() {
        return flights;
    }

    /**
     * @param flights the flights to set
     */
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
