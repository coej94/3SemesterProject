import React, {Component} from "react";
import FlightStore from "./FlightStore";
import {observer} from "mobx-react";

@observer
class FlightTable extends Component {


    render() {
        var search = FlightStore.flights.map(function (flight, index) {
            return (
                <div>

                    <div key={flight.flights[index].flightID}>
                        <h3>{flight.airline}</h3>
                        <p>FlightID: {flight.flights[0].flightID}</p>
                        <p>Date: {flight.flights[0].date}</p>
                        <p>Origin: {flight.flights[0].origin}</p>
                        <p>Destination: {flight.flights[0].destination}</p>
                        <p>NumberofSeats: {flight.flights[0].numberOfSeats}</p>
                        <p>Traveltime: {flight.flights[0].traveltime}</p>
                        <p>TotalPrice: {flight.flights[0].totalPrice}</p>
                    </div>
                </div>
            )
        });
        return (
            <div>
                {search}
            </div>
        );
    }
}
export default FlightTable;