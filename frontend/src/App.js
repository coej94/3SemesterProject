import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import FlightTable from './FlightTable';

class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
            <FlightTable/>
        </p>
      </div>
    );
  }
}

export default App;
