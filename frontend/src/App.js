import React, {Component} from 'react';
import './App.css';
import SearchModule from './components/SearchModule'
import Booking from './components/Booking'
import Admin from './components/Admin'
import Login from './components/Login'

import {BrowserRouter as Router, Route} from 'react-router-dom';
import Navbar from "./components/Navbar";

const test = () =>(
    <h1>her står der test</h1>
)

class App extends Component {

    state = {
        username: "",
        password: "123",
        loggedIn: false
    }

    updateState(e){
        console.log(e)
    }

    render() {
        return (
            <div className="App">
                <Router>
                    <div >
                        <Navbar/>
                        <Route exact path="/" render={props => <SearchModule/>}/>
                        <Route path="/book/:airline/:flightID" component={Booking}/>
                        <Route path="/test/" component={test}/>
                        <Route path="/login" render={props => <Login/>} />
                        <Route path="/Admin" component={Admin}/>
                    </div>
                </Router>

            </div>
        );
    }
}

export default App;
