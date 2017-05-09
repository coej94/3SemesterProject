package rest;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.UrlGetter;

/**
 * REST Web Service
 *
 * @author plaul1
 */
@Path("flights")
public class MomondoService {

    Gson gson = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of A
     */
    public MomondoService() {
    }

    /**
     * Retrieves representation of an instance of rest.All
     *
     * @param dest
     * @param passengers
     * @param date
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{dest}/{date}/{passengers}/")
    public String getToDest(@PathParam("dest") String dest, @PathParam("date") String date, @PathParam("passengers") String passengers) {
        return gson.toJson(new UrlGetter(dest, date, passengers).getData());
    }

    /**
     *
     * @param dest
     * @param to
     * @param date
     * @param passengers
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{dest}/{to}/{date}/{passengers}/")
    public String getToFromDest(@PathParam("dest") String dest, @PathParam("to") String to, @PathParam("date") String date, @PathParam("passengers") String passengers) {
        return gson.toJson(new UrlGetter(dest, to, date, passengers).getData());
    }
}
