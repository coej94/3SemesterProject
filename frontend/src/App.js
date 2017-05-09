import React, {Component} from 'react';
import './App.css';
import SearchModule from './components/SearchModule'
import Booking from './components/Booking'

import {BrowserRouter as Router, Route} from 'react-router-dom';
import Navbar from "./components/Navbar";

const test = () =>(
    <h1>her står der test</h1>
)

class App extends Component {
    render() {
        return (
            <div className="App">
                <Router>
                    <div >
                        <Navbar/>
                        <Route exact path="/" render={props => <SearchModule/>}/>
                        <Route path="/book/:airline/:flightID" component={Booking}/>
                        <Route path="/test/" component={test}/>
                    </div>
                </Router>

            </div>
        );
    }
}

export default App;
