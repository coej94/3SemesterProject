package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.RandomData;

@Path("flights")
public class FlightService {

    private static final RandomData DATA = new RandomData();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private List<Flight> flights = new ArrayList();

    public Flight getFlightByID(String id) {
        for (Flight flight : flights) {
            if (flight.getFlightID().equals(id)) {
                return flight;
            }
        }
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomFlight() {
        Flight randomFlight = DATA.getFlight();
        flights.add(randomFlight);
        return GSON.toJson(randomFlight);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{flightID}")
    public String getFlightByFlightID(@PathParam("flightID") String flightID) {
        return GSON.toJson(getFlightByFlightID(flightID));
    }

}
