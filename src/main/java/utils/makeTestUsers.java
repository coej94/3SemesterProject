package utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class makeTestUsers {

    //Only for initial testing REMOVE BEFORE PRODUCTION
    //Run this file to setup the users required to use the initial version of the seed
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("pu_development").createEntityManager();
        Persistence.generateSchema("pu_development", null);
    }
}
