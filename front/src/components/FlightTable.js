import React, {Component} from "react";
import FlightFactory from "./FlightStore";
import {observer} from "mobx-react";

@observer
class FlightTable extends Component {

    render() {
        var rows = FlightFactory.flights.map(function (flight) {
            return (
                <tr>
                    <td>{flight?flight.airline:""}</td>
                </tr>
            )
        });
        return (
            <table className="table">
                <thead>
                <tr>
                    <th>Airline</th>
                </tr>
                </thead>

                <tbody>
                {rows}
                </tbody>
            </table>
        );
    }
}
export default FlightTable;