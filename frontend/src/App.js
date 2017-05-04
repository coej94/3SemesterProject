import React, {Component} from 'react';
import './App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            flight: [],
            date: ""
        }
    }

    searchData(dest,passengers) {
        fetch('http://localhost:8084/seedMaven/api/demoall/'+dest+'/'+this.state.date+'T00:00:00.000Z/'+passengers)
            .then(res => res.json())
            .then(flight => {
                this.setState({flight}, () => console.log())
            })
    }

    handleChange(e) {
        this.setState({
            date: e.target.value
        }, () => console.log())
    }

        search(){
            this.searchData("CPH",1)
        }
    render() {
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


        return (
            <div>
                <input type="date" onChange={this.handleChange.bind(this)}/>
                <input type="button" value="Search" onClick={this.search.bind(this)}/>
                {search}
            </div>
        );
    }
}

export default App;
