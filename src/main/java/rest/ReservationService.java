package rest;

import com.google.gson.Gson;
import entity.FlightReservation;
import entity.User;
import facades.UserFacade;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @GET
    @Path("{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getReservations(@PathParam("user")String username){
        return gson.toJson(uf.getFlightReservations(username));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getFlightReservation(String user) {
        try {
            User u = gson.fromJson(user, User.class);
            new UserFacade("pu_development").updateReservation(u);
            FlightReservation fr = u.getReservations().get(0);
            ReservationHandler rh = new ReservationHandler();
            System.out.println(rh.requestReservation(fr));
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
        new UserFacade("pu_development").updateReservation(u);
    }

}
