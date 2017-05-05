package entity;

import java.util.List;


public class Airline {

    private final String name;
    private List<Flight> flights;

    public Airline(String name, List<Flight> flights) {
        this.name = name;
        this.flights = flights;
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
