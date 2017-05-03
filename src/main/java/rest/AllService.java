/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
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
@Path("demoall")
public class AllService {

    Gson gson = new Gson();
    
  @Context
  private UriInfo context;

  /**
   * Creates a new instance of A
   */
  public AllService() {
  }

  /**
   * Retrieves representation of an instance of rest.All
     * @param dest
     * @param passengers
     * @param date
   * @return an instance of java.lang.String
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{dest}/{date}/{passengers}/")
  public String getText(@PathParam("dest") String dest,@PathParam("date") String date,@PathParam("passengers") String passengers ) {
    return gson.toJson(new UrlGetter().getData("GET",dest,date,passengers));
  }

}
