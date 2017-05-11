import React, {Component} from 'react';
const URL = require("../../package.json").serverURL;

class Booking extends Component {

    state={
        numberOfSeats:"",
        reserveeName:"",
        reservePhone:"",
        reserveeEmail:"",
        passengers:[]
    }

    postData() {
        var res={
            airline:this.props.match.params.airline,
            reservation:{
                flightID:this.props.match.params.flightID,
                numberOfSeats:this.state.numberOfSeats,
                reserveeName:this.state.reserveeName,
                reservePhone:this.state.reservePhone,
                reserveeEmail:this.state.reserveeEmail,
                passengers:this.state.passengers
            }
        }
        console.log(res)
        // var options = {
        //     method: "POST",
        //     body: JSON.stringify(res),
        //     headers: new Headers({
        //         'Content-Type': 'application/json'
        //     })
        // }
        //
        // fetch(URL + "api/flightreservation", options)
        //     .then(response => response.json()).then(json=>{console.log(json)})
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
                <h1>Booking</h1>
                <h2>Airline: {match.params.airline}</h2>
                <h3>FlightID: {match.params.flightID}</h3>
                <label >Reservee Name: </label>
                <input type="text" name="reserveeName" onChange={this.handleChange.bind(this)}/>
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
