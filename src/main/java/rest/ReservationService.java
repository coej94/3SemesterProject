package rest;

import com.google.gson.Gson;
import entity.FlightReservation;
import facades.UserFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
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
    UserFacade uf = new UserFacade(Persistence.createEntityManagerFactory("pu_development"));
    
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
            //entity.User u = gson.fromJson(flightReservation, entity.User.class);
            ReservationHandler rh = new ReservationHandler();
            //System.out.println(uf.addReservation(u));
            return rh.requestReservation(fr);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "{\"ReservationServiceSucces\":\"false\"}";
    }
    
}
