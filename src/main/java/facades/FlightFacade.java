/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Flight;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


/**
 *
 * @author Staal
 */
public class FlightFacade {
    
    EntityManagerFactory emf;
    
    public FlightFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Flight addFlight(String flightID, String date, String origin, String destination, String flightNumber, int numberOfSeats, int traveltime, float totalPrice){
        EntityManager em = getEntityManager();
        try {
            Flight flight = new Flight(flightID, date, origin, destination, flightNumber, numberOfSeats, traveltime, totalPrice);
            em.getTransaction().begin();
            em.persist(flight);
            em.getTransaction().commit();
            return flight;
        }finally {
            em.close();
        }
    }
    
    public Flight getFlightByID(String flightID){
        EntityManager em = getEntityManager();
        try{
            Flight f = em.find(Flight.class, flightID);
            return f;
        } finally {
            em.close();
            
        }
    }
    
}
