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
        let passList = this.addPassengersToState()
        var res = {
            userName: auth.userName,
            FlightReservations: [{
                airline: this.props.match.params.airline,
                reservation: {
                    flightID: this.props.match.params.flightID,
                    numberOfSeats: this.props.match.params.seats,//this.state.numberOfSeats,
                    reserveeName: this.state.reserveeName,
                    reservePhone: this.state.reservePhone,
                    reserveeEmail: this.state.reserveeEmail,
                    passengers: passList
                }
            }]

        }
        console.log(res)
        const options = fetchHelper.makeOptions("PUT", true, res)
        fetch(URL + "api/flightreservation", options)
        // .then(response => response.json()).then(json => {
        // console.log(json)
        // })
    }

    addPassengersToState() {
        let firstname = document.getElementsByName("firstname");
        let lastname = document.getElementsByName("lastname");
        let fList = []
        let lList = []
        firstname.forEach((firstname) => {
            fList.push(firstname.value)
        })
        lastname.forEach((lastname)=>{
            lList.push(lastname.value)
        })

        let pList = []
        for(var i = 0;i<fList.length;i++){
            pList.push({firstName:fList[i],lastName:lList[i]})
        }
        return pList;
    }

    handleChange(e) {
        this.setState({
            [e.target.name]: e.target.value
        }, () => console.log())
    }

    renderPassengerInput() {
        var something = [];
        for (var i = 0; i < this.props.match.params.seats; i++) {
            something.push(
                <div key={i}>
                    <label>Passenger: {i + 1}</label>
                    <br/>
                    <label>Firstname: </label>
                    <input type="text" name="firstname"/>
                    <label>Lastname: </label>
                    <input type="text"name="lastname"/>
                </div>
            )
        }
        return something;
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
                    {this.renderPassengerInput()}
                    <br/>
                    <button>Book</button>
                </form>
            </div>
        );
    }
}

export default Booking;
