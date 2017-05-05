package test;

import model.CreateRandomData;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

        assertEquals(18, id.length());
        assertEquals("-", id.substring(4, 5));
        assertEquals(id.getClass(), String.class);
    }

    @Test
    public void testGetDate() {
        String date = crd.getDate();

        assertEquals(24, date.length());
        assertEquals("-", date.substring(4, 5));
        assertEquals("-", date.substring(7, 8));
        assertEquals(":", date.substring(13, 14));
        assertEquals(":", date.substring(16, 17));
        assertEquals(".", date.substring(19, 20));
        assertEquals(date.getClass(), String.class);
    }

    @Test
    public void testGetOrigin() {
        String origin = crd.getOrigin();

        assertEquals(3, origin.length());
        assertEquals(origin.getClass(), String.class);
    }

    @Test
    public void testGetDestination() {
        String destination = crd.getDestination();

        assertEquals(3, destination.length());
        assertEquals(destination.getClass(), String.class);
    }

    @Test
    public void testGetFlightNumber() {
        String flightNumber = crd.getFlightNumber();

        assertEquals(7, flightNumber.length());
        assertEquals(flightNumber.getClass(), String.class);
    }

    @Test
    public void testGetNumberOfSeats() {
        Integer numberOfSeats = crd.getNumberOfSeats();

        assertTrue(0 < numberOfSeats);
        assertEquals(numberOfSeats.getClass(), Integer.class);
    }

    @Test
    public void testGetTraveltime() {
        Integer traveltime = crd.getTraveltime();

        assertTrue(30 < traveltime);
        assertEquals(traveltime.getClass(), Integer.class);
    }

    @Test
    public void testGetTotalPrice() {
        Float totalPrice = crd.getTotalPrice();

        assertTrue(10 < totalPrice);
        assertEquals(totalPrice.getClass(), Float.class);
    }
}
