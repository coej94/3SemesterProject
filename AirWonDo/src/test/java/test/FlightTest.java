package test;

import model.CreateRandomData;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class FlightTest {
    
    static CreateRandomData crd;
    
    @BeforeClass
    public static void initFacade() {
        crd = new CreateRandomData();
    }

    @Test
    public void testGetRandomFlightID() {
        String id = crd.getFlightID();
        assertEquals("2215-1495540800000", id);
    }

//    @Test
//    public void testAddFlight() {
//        Flight flight = new Flight("4432-534231221325", "2017-10-11", "CPH", "DXB", "DK233", 1, 520, (float) 150.6);
//        facade.addFlight(flight);
//
//        //Verify that flight was actually inserted in the database
//        Flight newFlight = facade.getFlightByID("4432-534231221325");
//        assertEquals("4432-534231221325", newFlight.getFlightID());
//    }
    
}
