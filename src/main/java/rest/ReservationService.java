package rest;

import com.google.gson.Gson;
import entity.FlightReservation;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.ReservationHandler;
import model.UrlGetter;

/**
 * REST Web Service
 *
 * @author Asger
 */
@Path("flightreservation")
public class ReservationService {

    Gson gson = new Gson();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Reservation
     */
    public ReservationService() {
    }

//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{flightId}/")
//    public String getToDest(@PathParam("flightId") String dest, String reservation) {
//        try {
//            Reservation r = gson.fromJson(reservation, Reservation.class);
//            Flight f = new Flight(r.getFlightId(), "2017-05-10T03:26:00.000Z", "CPH", "SFX", "123-12310", 1, 101, 2);
//            System.out.println(f.toString());
//
//            String s = "";
//            for (int i = 0; i < r.getPassengers().size(); i++) {
//                s += "{\"firstName\": \"" + r.getPassengers().get(i).getFirstName() + "\",\"lastName\": \"" + r.getPassengers().get(i).getLastName() + "\"},";
//            }
//            s = s.substring(0, s.length() - 1);
//            String result = "{\"flightNumber\" : \"" + f.getFlightNumber() + "\",\"origin\": \"" + f.getOrigin() + "\",\"destination\": \"" + f.getDestination() + "\",\"date\": \"" + f.getDate() + "\",\"flightTime\": \"" + f.getTraveltime() + "\",\"numberOfSeats\": \"" + f.getNumberOfSeats() + "\",\"reserveName\": \"" + r.getReserveName() + "\",\"passengers\": [" + s + "]}";
//            System.out.println(result);
//            return result;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return "";
//    }
//
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getFlightReservation(String flightReservation) {
        try {
            FlightReservation fr = gson.fromJson(flightReservation, FlightReservation.class);
            ReservationHandler rh = new ReservationHandler();
            return rh.requestReservation(fr);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "{\"ReservationServiceSucces\":\"false\"}";
    }
    
}
