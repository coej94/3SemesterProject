import React, {Component} from 'react';
import './App.css';
import SearchModule from './components/SearchModule';
import Booking from './components/Booking';
import Admin from './components/Admin';
import Login from './components/Login';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Header from "./components/Header";

const test = () =>(
    <h1>her står der test</h1>
)

class App extends Component {

    render() {
        return (
            <div className="App">

                <Router>
                    <div >
                        <Header/>
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
