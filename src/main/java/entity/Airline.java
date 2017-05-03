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

/**
 *
 * @author Staal
 */
@Entity
public class Airline implements Serializable {
    
    public Airline(){
        
    }
    
    @Id
    String airline;
    List<Flight> flights;

    public Airline(int airlineID, String airline, List<Flight> flights) {
        this.airline = airline;
        this.flights = flights;
    }
    
    @Override
    public String toString(){
        return airline+flights;
    }
    
}
