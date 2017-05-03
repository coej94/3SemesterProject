package utils;

import entity.Flight;
import facades.FlightFacade;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class makeTestUsers {

    //Only for initial testing REMOVE BEFORE PRODUCTION
    //Run this file to setup the users required to use the initial version of the seed
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("pu_development").createEntityManager();
        Persistence.generateSchema("pu_development", null);
        
        FlightFacade flightFacade = new FlightFacade("pu_development");
        
        Flight flight = new Flight("2222-534231221325", "2017-09-23", "CPH", "ISB", "DK323", 2, 200, (float) 230.4);
        flightFacade.addFlight(flight);
    }
}
