import React, {Component} from 'react';
const URL = require("../../package.json").serverURL;
import auth from "../components/auth";
class History extends Component {

    state = {
        reservation: []
    }

    searchData() {
        let user = auth.userName
        fetch(URL + 'api/flightreservation/' + user)
            .then(res => res.json())
            .then(res => {
                this.setState({
                    reservation: res
                }, () => console.log(console.log()))
            })
    }

    componentDidMount() {
        this.searchData();
    }

    renderHistory() {
        let table = this.state.reservation.map((reservation, index) => {
            if (reservation != null) {
                    return (
                        <div key={index}>
                            <hr/>
                            <h3>Reservation id: {reservation.id}</h3>
                            <p>Airline: {reservation.airline}</p>
                            <p>FlightID: {reservation.reservation.flightID}</p>
                            <p>Number of seats: {reservation.reservation.numberOfSeats}</p>
                            <p>Reserve phone: {reservation.reservation.reservePhone}</p>
                            <p>Reservee email:{reservation.reservation.reserveeEmail}</p>
                            <p>Reservee name:{reservation.reservation.reserveeName} </p>
                            <h3>Passengers:</h3>
                            {reservation.reservation.passengers.map((passenger)=>{
                                return  <p key={passenger.firstName}>Firstname: {passenger.firstName} lastname: {passenger.lastName}</p>
                            })}

                        </div>
                    )
            }
            return null;
        })
        return table;


    }


    render() {
        return (
            <div className="container">
                {this.renderHistory()}
            </div>
        );
    }
}

export default History;
