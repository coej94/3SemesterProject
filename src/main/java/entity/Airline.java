package entity;

import java.util.List;

/**
 *
 * @author Joacim
 */
public class Airline {
    String airline;
    List<Flight> flights;

    public Airline(String airline, List<Flight> flights) {
        this.airline = airline;
        this.flights = flights;
    }
    
    @Override
    public String toString(){
        return airline+flights.get(0);
    }
    
    
}
