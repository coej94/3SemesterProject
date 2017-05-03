package facades;

import entity.Airline;
import entity.Flight;
import java.util.ArrayList;
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

    //String flightID, String date, String origin, String destination, String flightNumber, int numberOfSeats, int traveltime, float totalPrice
    public void starter() {
        addFlight(new Flight("1", "date", "zam", "cph", "1", 1, 1, 1));
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Airline createAirline(String airline) {
        EntityManager em = getEntityManager();
        Airline a = new Airline(airline, new ArrayList());
        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return a;
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
