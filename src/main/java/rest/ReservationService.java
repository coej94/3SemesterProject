package rest;

import com.google.gson.Gson;
import entity.FlightReservation;
import entity.User;
import facades.UserFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import model.ReservationHandler;

/**
 * REST Web Service
 *
 * @author Asger
 */
@Path("flightreservation")
public class ReservationService {

    Gson gson = new Gson();
    UserFacade uf = new UserFacade("pu_development");

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Reservation
     */
    public ReservationService() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getFlightReservation(String flightReservation) {
        try {
            FlightReservation fr = gson.fromJson(flightReservation, FlightReservation.class);
            ReservationHandler rh = new ReservationHandler();
            return rh.requestReservation(fr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "{\"ReservationServiceSucces\":\"false\"}";
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void updateUserReservation(String user) {
        User u = gson.fromJson(user, User.class);
        System.out.println(u.getPassword());
        new UserFacade("pu_development").updateReservation(u);
    }

}
