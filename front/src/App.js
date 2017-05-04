import React, {Component} from 'react';
import Flight from './components/FlightTable';
import {observable, computed, action} from  "mobx";
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

    render() {
        return (
            <div>
                <input type="date" onChange={this.handleChange}/>
                <input type="button" value="search"/>
                <Flight/>
            </div>
        )
    }
}

export default App;