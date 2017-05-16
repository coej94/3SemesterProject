import React, {Component} from 'react';
import './App.css';
import SearchModule from './components/SearchModule';
import Booking from './components/Booking';
import Admin from './components/Admin';
import Login from './components/Login';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Header from "./components/Header";
import History from './components/History'

const test = () => (
    <h1>her står der test</h1>
)

class App extends Component {
    state = {
        rerender: false
    }

    updateState() {
        this.setState({
            rerender: true
        })
        history.pushState('/');
    }

    render() {
        return (
            <div className="App">
                <Router>
                    <div >
                        <Header update={this.updateState.bind(this)}/>
                        <Route exact path="/" render={props => <SearchModule/>}/>
                        <Route path="/book/:airline/:flightID/:seats" component={Booking}/>
                        <Route path="/test/" component={test}/>
                        <Route path="/login" render={props => <Login update={this.updateState.bind(this)}/>}/>
                        <Route path="/Admin" component={Admin}/>
                        <Route path="/history" component={History}/>
                    </div>
                </Router>
            </div>
        );
    }
}

export default App;
