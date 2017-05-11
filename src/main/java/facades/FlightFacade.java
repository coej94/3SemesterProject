package facades;

import entity.Airline;
import entity.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class FlightFacade {

    private EntityManagerFactory emf;

    public FlightFacade(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }

    public static void main(String[] args) {
        new FlightFacade("pu_development").starter();   
    }

    public void starter() {
       createAirline(new Airline("penisline", new ArrayList()));
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Airline createAirline(Airline airline) {
        System.out.println(airline);
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(airline);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return airline;
    }

    public Flight addFlight(Flight f) {

        EntityManager em = getEntityManager();
        Airline a = em.find(Airline.class, "AirWonDo");
        a.addFlight(f);
        try {
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return a.getLatestFlight();
    }

    public Flight getFlightByID(String flightID) {
        EntityManager em = getEntityManager();
        try {
            Flight f = em.find(Flight.class, flightID);
            return f;
        } finally {
            em.close();

        }
    }

}
