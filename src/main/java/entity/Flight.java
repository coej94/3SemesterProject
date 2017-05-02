package entity;

/**
 *
 * @author Joacim
 */
class Flight {
    String flightID,date,origin,destination,flightNumber;
    int numberOfSeats,traveltime;
    float totalPrice;

    public Flight(String flightID, String date, String origin, String destination, String flightNumber, int numberOfSeats, int traveltime, float totalPrice) {
        this.flightID = flightID;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.numberOfSeats = numberOfSeats;
        this.traveltime = traveltime;
        this.totalPrice = totalPrice;
    }
    
    
    
}
