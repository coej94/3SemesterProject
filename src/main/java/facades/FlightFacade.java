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
    
    public static void main(String[] args) {
        
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
