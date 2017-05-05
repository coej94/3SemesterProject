package test;

import entity.Flight;
import entity.PU;
import facades.FlightFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class FlightFacadeTest {

    FlightFacade facade;

    public FlightFacadeTest() {
        facade = new FlightFacade(PU.getPersistenceUnitName());
    }

    //Override this in a derived class to use an alternative database
    public static void setPersistenceUnit() {
        PU.setPU_Name("pu_memorydb_mock");
    }

    @BeforeClass
    public static void initFacade() {
        setPersistenceUnit();
        //Setup test flights
        utils.makeTestFlights.main(null);
    }

    @Test
    public void testGetExsistingFlightById() {
        Flight flight = facade.getFlightByID("2222-534231221325");
        System.out.println(flight.getFlightID());
        assertEquals("2222-534231221325", flight.getFlightID());
    }

    @Test
    public void testGetNonExsistingFlightById() {
        Flight flight = facade.getFlightByID("i_dont_exist");
        assertNull(flight);
    }

    @Test
    public void testAddFlight() {
        Flight flight = new Flight("4432-534231221325", "2017-10-11", "CPH", "DXB", "DK233", 1, 520, (float) 150.6);
        facade.addFlight(flight);

        //Verify that flight was actually inserted in the database
        Flight newFlight = facade.getFlightByID("4432-534231221325");
        assertEquals("4432-534231221325", newFlight.getFlightID());
    }

}
