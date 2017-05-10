package test;

import model.RandomData;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

public class FlightTest {

    static RandomData rd;

    @BeforeClass
    public static void initFacade() {
        rd = new RandomData();
    }

    @Test
    public void testGetFlightID() {
        String id = rd.getFlightID();

        assertEquals(18, id.length());
        assertEquals("-", id.substring(4, 5));
        assertEquals(id.getClass(), String.class);
    }

    @Test
    public void testGetDate() {
        String date = rd.getDate("2017-05-20T13:00:00.000Z");

        assertEquals(24, date.length());
        assertEquals("-", date.substring(4, 5));
        assertEquals("-", date.substring(7, 8));
        assertEquals(":", date.substring(13, 14));
        assertEquals(":", date.substring(16, 17));
        assertEquals(".", date.substring(19, 20));
        assertEquals(date.getClass(), String.class);
    }

    @Test
    public void testGetDestination() {
        String destination = rd.getDestination();

        assertEquals(3, destination.length());
        assertEquals(destination.getClass(), String.class);
    }

    @Test
    public void testGetFlightNumber() {
        String flightNumber = rd.getFlightNumber("SXF");

        assertEquals(7, flightNumber.length());
        assertEquals(flightNumber.getClass(), String.class);
    }

    @Test
    public void testGetTraveltime() {
        Integer traveltime = rd.getTravelTime();

        assertTrue(30 < traveltime);
        assertEquals(traveltime.getClass(), Integer.class);
    }

    @Test
    public void testGetTotalPrice() {
        Float totalPrice = rd.getTotalPrice(3);

        assertTrue(50 <= totalPrice);
        assertEquals(totalPrice.getClass(), Float.class);
    }
}
