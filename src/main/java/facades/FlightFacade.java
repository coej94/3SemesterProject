/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Flight;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Staal
 */
public class FlightFacade {
    
    private EntityManagerFactory emf;
    
    
    
    public FlightFacade(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }
    
    public static void main(String[] args) {
       new FlightFacade("pu_development").starter();
    }
    //String flightID, String date, String origin, String destination, String flightNumber, int numberOfSeats, int traveltime, float totalPrice
    public void starter(){
        addFlight(new Flight("id","date","zam","cph","1",1,1,1));
    }
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Flight addFlight(Flight flight){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(flight);
            em.getTransaction().commit();
            return getFlightByID(flight.getFlightID());
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
