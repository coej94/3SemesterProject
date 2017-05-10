/**
 * Created by Staal on 10/05/2017.
 */
/**
 * Created by Staal on 09/05/2017.
 */
import React, {Component} from 'react';
const URL = require("../../package.json").serverURL;

class Admin extends Component {

    constructor(props) {
        super(props)

        var airline = {
            airline: "",
            flights: []
        }

        this.state = {
            airline: airline
        }
    }


    // handleChange(e) {
    //     this.setState({
    //         [e.target.name]: e.target.value
    //     }, () => console.log())
    // }

    handleChange = (event) => {
        let id = event.target.id;
        let airline = this.state.airline;
        if (id === "airline") {
            airline.airline = event.target.value;
        }
        if (id === "flights") {
            airline.flights = event.target.value;
        }
        this.setState({airline: airline});
    }

    saveAirline = event => {
        event.preventDefault();
        let airline = this.state.airline;
        this.postAirline(airline);
    }

    postAirline() {
        var airline = {
            airline: "",
            flights: []
        }


        var options = {
            method: "POST",
            body: JSON.stringify(airline),
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        }

        fetch(URL + 'api/demoadmin/addAirline', options)
            .then(res => res.json)
            .then(airline => {
                this.setState({
                    airline: airline.airline,
                    flights: airline.flights
                }, () => console.log())
            })


    }


    render() {
        return (
            <div>
                <form>
                    <h2>Add Airline</h2>

                    <input onChange={this.handleChange.bind(this)} id="airline" type="text" required/>
                    <br/>
                    <input onClick={this.saveAirline.bind(this)} type="button" value="Add Airline"/>
                </form>
            </div>
        );
    }

}

export default Admin;