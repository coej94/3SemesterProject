import React, {Component} from 'react';
import './App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            flight: [],
            date: "",
            from: "CPH",
            to: "CPH",
            seats: ""
        }
    }

    searchData() {
        console.log(this.state)
        fetch('http://localhost:8084/seedMaven/api/flights/' + this.state.from + '/' + this.state.to + '/' + this.state.date + 'T00:00:00.000Z/' + this.state.seats)
            .then(res => res.json())
            .then(flight => {
                this.setState({flight}, () => console.log())
            })
    }

    search() {
        this.searchData();
    }

    handleChange(e) {
        this.setState({
            [e.target.name]: e.target.value
        }, () => console.log())
    }

    render() {
        if (this.state.flight[0] != null) {
            var search = this.state.flight.map(function (flight) {
                return (
                    <div key={flight.flights[0].flightID}>
                        <h3>{flight.airline}</h3>
                        <p>FlightID: {flight.flights[0].flightID}</p>
                        <p>Date: {flight.flights[0].date}</p>
                        <p>Origin: {flight.flights[0].origin}</p>
                        <p>Destination: {flight.flights[0].destination}</p>
                        <p>NumberofSeats: {flight.flights[0].numberOfSeats}</p>
                        <p>Traveltime: {flight.flights[0].traveltime}</p>
                        <p>TotalPrice: {flight.flights[0].totalPrice}</p>
                    </div>
                )
            });
        }
        let flyOptions = ["CPH", "SXF", "BCN", "CDG", "STN"];


        return (
            <div>
                <p>Fly from:
                    <select name="from" onChange={this.handleChange.bind(this)}>
                        {flyOptions.map((fly,index) => <option key={index} value={fly}>{fly}</option>)}
                    </select></p>

                <p>Departure Date:
                    <input type="date" name="date" onChange={this.handleChange.bind(this)}/></p>

                <p>Fly to:
                    <select name="to" onChange={this.handleChange.bind(this)}>
                        {flyOptions.map((fly,index) => <option key={index} value={fly}>{fly}</option>)}
                    </select></p>

                <p>Seats:
                    <input type="number" name="seats" onChange={this.handleChange.bind(this)}/>
                </p>
                <input type="button" value="Search" onClick={this.search.bind(this)}/>
                {search}
            </div>
        );
    }
}

export default App;
