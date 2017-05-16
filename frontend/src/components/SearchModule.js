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
                flight.forEach((flights) => {
                    sortedflights.push(flights);
                })
            }
        })
    }

    //     allFlights.forEach((flight) => {
    //         if (flight != null) {
    //             flight.forEach((flightitem) => {
    //                 flightitem.push(sortedflights);
    //             })
    //         }
    //     })
    //     console.log(sortedflights);
    // }

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

    /*
     DETTE ER UDKOMMENTERET INDTIL SORT DROPDOWNEN ER IMPLEMENTERET.
     <div className="dropdown">
     <button className="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort
     Flights By
     <span className="caret"></span></button>
     <ul className="dropdown-menu">
     <li><a href="#" onClick={this.sortByLowestPrice.bind(this)}>Lowest Price</a></li>
     <li><a href="#">Highest Price</a></li>
     <li><a href="#">Travel Time</a></li>
     </ul>
     </div>*/

    /* og hvad gør denne? <p>{this.getAllFlights()}</p>*/

    render() {
        return (
            <div>
                <div className="container order row col-md-12 text-center">
                    <h2>Where do you want to go?</h2>
                </div>
                <div className="booking-module filter travel-form container row" id="form-thing">
                    <form role="form">
                        <div className="row col-md-4">
                            <input type="date" className="form-control" name="date"
                                   onChange={this.handleChange.bind(this)}/>
                            <input type="number" className="form-control" name="seats"
                                   placeholder="seats" onChange={this.handleChange.bind(this)}/>
                            <button className=" form-control" type="button" data-toggle="dropdown">
                                Sort Flights By<span className="caret"></span></button>
                            <ul className="dropdown-menu">
                                <li><a href="#" onClick={this.sortByLowestPrice.bind(this)}>Lowest
                                    Price</a></li>
                                <li><a href="#">Highest Price</a></li>
                                <li><a href="#">Travel Time</a></li>
                            </ul>
                            <input className="form-control" type="button" value="Search"
                                   onClick={this.searchData.bind(this)}/>
                        </div>
                        <div className="col-md-8">
                            <select id="origin" className="form-control" name="from"
                                    onChange={this.handleChange.bind(this)}>
                                {this.state.flyOptions.map((fly, index) => <option key={index}
                                                                                   value={fly}>{fly}</option>)}
                            </select>
                            <select id="destination" className="form-control" name="to"
                                    onChange={this.handleChange.bind(this)}>
                                {this.state.flyOptions.map((fly, index) => <option key={index}
                                                                                   value={fly}>{fly}</option>)}
                            </select>
                            <input type="text" className=" form-control" placeholder="Min Price"/>
                            <input type="text" className="form-control" placeholder="Max Price"/>
                        </div>
                    </form>
                    <div className="search-res">
                        {this.nyRenderTable()}
                    </div>
                </div>
            </div>)

    }
}

export default SearchModule;
