import React, {Component} from 'react';
const URL = require("../../package.json").serverURL;
import auth from "../components/auth";
import fetchHelper from "./fetchHelpers";

class Booking extends Component {
    state = {
        numberOfSeats: "",
        reserveeName: "",
        reservePhone: "",
        reserveeEmail: "",
        passengers: []
    }

    postData(e) {
        e.preventDefault()
        var flightId = this.props.match.params.flightID;
        var res = {
            userName: auth.userName,
            FlightReservations: [{
                airline: this.props.match.params.airline,
                reservation: {
                    flightID: flightId,
                    numberOfSeats: 1,//this.state.numberOfSeats,
                    reserveeName: this.state.reserveeName,
                    reservePhone: this.state.reservePhone,
                    reserveeEmail: this.state.reserveeEmail,
                    passengers: [{firstName:"joacim", lastName:"vetterlain"}]//this.state.passengers
                }
            }]

        }
        console.log(res)
        const options = fetchHelper.makeOptions("PUT",true,res)
        fetch(URL + "api/flightreservation", options)
            // .then(response => response.json()).then(json => {
            // console.log(json)
        // })
    }

    handleChange(e) {
        this.setState({
            [e.target.name]: e.target.value
        }, () => console.log())
    }


    render() {
        const {match} = this.props;
        return (
            <div className="container">
                <form onSubmit={this.postData.bind(this)} value="Book">
                <h1>Booking</h1>
                <h2>Airline: {match.params.airline}</h2>
                <h3>FlightID: {match.params.flightID}</h3>
                <label >Reservee Name: </label>
                <input type="text" name="reserveeName" required onChange={this.handleChange.bind(this)}/>
                <br/>
                <label >Reservee Phone: </label>
                <input type="text" name="reservePhone" required onChange={this.handleChange.bind(this)}/>
                <br/>
                <label >Reservee Email: </label>
                <input type="email" name="reserveeEmail" required onChange={this.handleChange.bind(this)}/>
                <br/>
                add passenger +
                <br/>
                 <button>Book</button>
                </form>
            </div>
        );
    }
}

export default Booking;
