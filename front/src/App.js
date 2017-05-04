import React, {Component} from 'react';
import Flight from './components/FlightTable';
import {observable, computed, action} from  "mobx";
import React, {Component} from 'react'
import FlightTable from './components/FlightTable'
class App extends Component {

    @observable date = "";

    @computed get date(){
        return this.date;
    }
    getDate(){
        //console.log(this.date);
    }

    handleChange(e){
        const data = e.target.value;
        console.log(data);
    }
    state = {
        date: "hej"
    }


    handleChange(e) {
        this.setState({
            date: e.target.value
        }, () => console.log(this.state.date))
    }

    getDate() {
        return this.state.date;
    }

render() {
        return (
            <div>
                <input type="date" onChange={this.handleChange}/>
                <input type="button" value="search"/>
                <Flight/>

                <input type="date" onChange={this.handleChange.bind(this)}/>
                <FlightTable data={this.state.date}/>
            </div>
        )
    }
}

export default App;