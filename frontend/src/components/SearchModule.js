import React, {Component} from 'react';
const URL = require("../../package.json").serverURL;
import {Link} from 'react-router-dom';


class SearchModule extends Component {


    state = {
        flyOptions: ["CPH", "SXF", "BCN", "CDG", "STN"],
        flights: [],
        date: "",
        from: "CPH",
        to: "SXF",
        seats: "1",
        airline: []
    }

    searchData() {
        fetch(URL + 'api/flights/' + this.state.from + '/' + this.state.to + '/' + this.state.date + 'T00:00:00.000Z/' + this.state.seats)
            .then(res => res.json())
            .then(flight => {
                var flights = flight.map((airline) => {
                    return airline != null ? airline.flights : null
                })
                this.setState({
                    flights: flights,
                    airline: flight
                }, () => console.log())
            })
    }

    handleChange(e) {
        this.setState({
            [e.target.name]: e.target.value
        }, () => console.log())
    }

    sortByLowestPrice() {

        let newFlight = this.state.flights.map((flight) => {
            if (flight != null) {
                return flight.sort((a, b) => {
                    return a.totalPrice - b.totalPrice
                })
            }
            return null
        });
        this.setState({flights: newFlight}, () => console.log());

    }

    getAllFlights() {
        let allFlights = this.state.flights.map((flights) => {
            if (flights != null) {
                return flights;
            }
            return null;
        })

        let sortedflights = []
        allFlights.forEach((flight) => {
            if (flight != null) {
                flight.forEach((flightitem) => {
                    flight.push(flightitem);
                })
            }
        })
    }

    nyRenderTable() {

        let table = this.state.flights.map((airline, index) => {
            if (airline != null) {
                return airline.map((flight) => {
                    return (
                        <div key={flight.flightID}>
                            <hr/>
                            <h3>{this.state.airline[index].airline}</h3>
                            <p>FlightID: {flight.flightID}</p>
                            <p>Date: {flight.date}</p>
                            <p>From: {flight.origin}</p>
                            <p>Destination: {flight.destination}</p>
                            <p>NumberofSeats: {flight.numberOfSeats}</p>
                            <p>Traveltime: {flight.traveltime} minutter</p>
                            <p>TotalPrice: {flight.totalPrice} kr.</p>
                            <Link to={'/book/' + this.state.airline[index].airline + '/' + flight.flightID}>Go to
                                booking</Link>
                        </div>
                    )
                })
            }
            return null;
        })
        return table;

    }


    render() {
        return (
            <div className="container">
                <p>Fly from:
                    <select name="from" onChange={this.handleChange.bind(this)}>
                        {this.state.flyOptions.map((fly, index) => <option key={index} value={fly}>{fly}</option>)}
                    </select></p>
                <p>Departure Date:
                    <input type="date" name="date" onChange={this.handleChange.bind(this)}/></p>
                <p>Fly to:
                    <select name="to" onChange={this.handleChange.bind(this)}>
                        {this.state.flyOptions.map((fly, index) => <option key={index} value={fly}>{fly}</option>)}
                    </select></p>
                <p>Seats:
                    <input type="number" name="seats" onChange={this.handleChange.bind(this)}/>
                </p>
                <p>Sort After</p>
                <div className="dropdown">
                    <button className="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort
                        Flights By
                        <span className="caret"></span></button>
                    <ul className="dropdown-menu">
                        <li><a href="#" onClick={this.sortByLowestPrice.bind(this)}>Lowest Price</a></li>
                        <li><a href="#">Highest Price</a></li>
                        <li><a href="#">Travel Time</a></li>
                    </ul>
                </div>
                <p>{this.getAllFlights()}</p>
                <p>pris:</p>
                <input type="search" placeholder="fra"/>
                <input type="search" placeholder="til"/>
                <br/>
                <input type="button" value="Search" onClick={this.searchData.bind(this)}/>
                <p></p>
                {this.nyRenderTable()}

            </div>
        );
    }
}

export default SearchModule;
