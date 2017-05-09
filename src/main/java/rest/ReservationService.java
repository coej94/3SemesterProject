package rest;

import com.google.gson.Gson;
import entity.Flight;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import entity.Reservation;
import facades.FlightFacade;
/**
 * REST Web Service
 *
 * @author Asger
 */
@Path("reservation")
public class ReservationService {

    Gson gson = new Gson();
    FlightFacade ff = new FlightFacade("pu_development");
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Reservation
     */
    public ReservationService() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{flightId}/")
    public String getToDest(@PathParam("flightId") String dest, String reservation) {
        Reservation r = gson.fromJson(reservation, Reservation.class);
        Flight f = ff.getFlightByID(r.getFlightId());
        
        String s = "";
        for (int i = 0; i < r.getPassengers().size(); i++) {
            s += "{\"firstName\": \""+r.getPassengers().get(i).getFirstName()+"\",\"lastName\": \""+r.getPassengers().get(i).getLastName()+"\"},";
        }
        //s = s.substring(0, s.length()-1);
        return "{\"flightNumber\" : \""+f.getFlightNumber()+"\",\"origin\": \""+f.getOrigin()+"\",\"destination\": \""+f.getDestination()+"\",\"date\": \""+f.getDate()+"\",\"flightTime\": \""+f.getTraveltime()+"\",\"numberOfSeats\": \""+f.getNumberOfSeats()+"\",\"reserveName\": \""+r.getReserveName()+"\",\"passengers\": ["+s+"]}";
    }
}
