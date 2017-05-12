import React, {Component} from 'react';
const URL = require("../../package.json").serverURL;

class Booking extends Component {
    postData() {
        var res={
            airline:this.props.match.params.airline,
            reservation:{
                flightID:this.props.match.params.flightID,
                numberOfSeats:"",
                reserveeName:"",
                reservePhone:"",
                reserveEmail:"",
                passengers:[
                    {firstName:"",lastname:""},
                ]
            }
        }

        console.log(res)

        var options = {
            method: "POST",
            body: JSON.stringify(res),
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        }

        fetch(URL + "api/flightreservation", options)
    }

    render() {
        const {match} = this.props;
        console.log(this.props)
        return (
            <div className="container">
                <h1>Booking</h1>
                <h2>Airline: {match.params.airline}</h2>
                <h3>FlightID: {match.params.flightID}</h3>
                <label >Reservee Name: </label>
                <input type="text"/>
                <br/>
                <label >Reservee Phone: </label>
                <input type="text"/>
                <br/>
                <label >Reservee Email: </label>
                <input type="email"/>
                <br/>
                add passenger +
                <br/>
                <input type="button" onClick={this.postData.bind(this)} value="Book"/>
            </div>
        );
    }
}

export default Booking;