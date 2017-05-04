package utils;

import entity.Airline;
import entity.Flight;
import entity.PU;
import facades.FlightFacade;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class makeTestFlights {

    //Only for initial testing REMOVE BEFORE PRODUCTION
    //Run this file to setup the users required to use the initial version of the seed
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("pu_development").createEntityManager();
        Persistence.generateSchema("pu_development", null);

        FlightFacade flightFacade = new FlightFacade(PU.getPersistenceUnitName());

        Flight flight = new Flight("2222-534231221325", "2017-09-23", "CPH", "ISB", "DK323", 2, 230, (float) 230.4);
        flightFacade.createAirline("AirWonDo");
        flightFacade.addFlight(flight);
    }
}
