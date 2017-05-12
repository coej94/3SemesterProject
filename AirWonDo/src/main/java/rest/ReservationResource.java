package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Flight;
import entity.Reservation;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Data;

@Path("reservation")
public class ReservationResource {

    private static final Data DATA = new Data();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public Flight getFlightByID(String id) {
        for (Flight flight : FlightService.flights) {
            if (flight.getFlightID().equals(id)) {
                return flight;
            }
        }
        return null;
    }

    @POST
    @Path("{flightId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String makeReservation(@PathParam("flightId") String flightId, String content) {
        Reservation reservation = GSON.fromJson(content, Reservation.class);
        Flight flight = getFlightByID(flightId);
        return GSON.toJson(DATA.getReservationResponse(flight, reservation));
    }
}
