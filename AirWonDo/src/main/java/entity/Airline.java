package entity;

import java.util.ArrayList;
import java.util.List;

public class Airline {

    private final String airline;
    private List<Flight> flights;

    public Airline() {
        airline = "AirWonDO";
        flights = new ArrayList();
    }

    public void addFlight(Flight f) {
        flights.add(f);
    }

    /**
     * @return the flights
     */
    public List<Flight> getFlights() {
        return flights;
    }

    public Flight getLatestFlight() {
        return flights.get(flights.size() - 1);
    }

    /**
     * @param flights the flights to set
     */
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

}
