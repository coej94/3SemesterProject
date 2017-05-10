import React, {Component} from 'react';
const URL = require("../../package.json").serverURL;
import fetchHelper from "./fetchHelpers";

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

    postAirline() {

        var airline = {
            airline: this.state.airline.airline,
            flights: []
        }

        const options = fetchHelper.makeOptions("POST",true,airline)

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
                    <input onClick={this.postAirline.bind(this)} type="button" value="Add Airline"/>
                </form>
            </div>
        );
    }

}

export default Admin;