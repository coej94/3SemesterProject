/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Staal
 */
@Entity
public class Airline implements Serializable {
    
    public Airline(){
        
    }
    
    @Id
    private String airline;
    @OneToMany
    private List<Flight> flights;

    public Airline(String airline, List<Flight> flights) {
        this.airline = airline;
        this.flights = flights;
    }
    
    @Override
    public String toString(){
        return getAirline()+getFlights();
    }

    /**
     * @return the airline
     */
    public String getAirline() {
        return airline;
    }

    /**
     * @param airline the airline to set
     */
    public void setAirline(String airline) {
        this.airline = airline;
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
