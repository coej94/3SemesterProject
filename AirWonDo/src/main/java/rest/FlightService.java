package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Airline;
import entity.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Data;

@Path("flights")
public class FlightService {

    private static final Data DATA = new Data();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    static List<Flight> flights = new ArrayList();

    @GET
    @Path("{origin}/{date}/{numberOfSeats}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAirline(@PathParam("origin") String origin, @PathParam("date") String date, @PathParam("numberOfSeats") int numberOfSeats) {
        Airline airWonDo = DATA.getAirline(origin, date, numberOfSeats);

        airWonDo.getFlights().forEach((flight) -> {
            flights.add(flight);
        });

        return GSON.toJson(airWonDo);
    }

    @GET
    @Path("{origin}/{destination}/{date}/{numberOfSeats}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAirline(@PathParam("origin") String origin, @PathParam("destination") String destination, @PathParam("date") String date, @PathParam("numberOfSeats") int numberOfSeats) {
        Airline airWonDo = DATA.getAirline(origin, destination, date, numberOfSeats);

        airWonDo.getFlights().forEach((flight) -> {
            flights.add(flight);
        });

        return GSON.toJson(airWonDo);
    }
}
