package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Airline;
import facades.FlightFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("demoadmin")
//@RolesAllowed("Admin")
public class Admin {

    private static final FlightFacade FACADE = new FlightFacade("pu_development");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSomething() {
        String now = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date());
        return "{\"message\" : \"Hello Admin from server (call accesible by only authenticated ADMINS)\",\n" + "\"serverTime\": \"" + now + "\"}";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addAirline")
    public String addAirline(String airline) {
        System.out.println(airline);
        Airline a = GSON.fromJson(airline, Airline.class);
        return GSON.toJson(FACADE.createAirline(a));
    }

}
