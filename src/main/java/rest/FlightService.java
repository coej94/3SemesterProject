package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Flight;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class FlightService {

//    private static final FlightFacade FACADE = new FlightFacade("pu_development");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("flight")
    public class flight {
//
//        @GET
//        @Produces(MediaType.APPLICATION_JSON)
//        @Path("/{flightID}")
//        public String getFlightByFlightID(@PathParam("flightID") String flightID) {
//            Flight f = FACADE.getFlightByID(flightID);
//            return GSON.toJson(f);
//        }

//        @POST
//        @Produces(MediaType.APPLICATION_JSON)
//        @Path("addFlight")
//        public String addFlight(String flight) {
//            System.out.println(GSON.fromJson(flight, Flight.class));
//            Flight f = GSON.fromJson(flight, Flight.class);
//            return GSON.toJson(FACADE.addFlight(f));
//        }
    }
}