import React, {Component} from 'react'
import Flight from './components/FlightTable'
class App extends Component {


state={
    date:"asger"
}

printDate(){
    console.log(this.state.date);
}

    render() {
        return (
            <div>
                {this.state.date}
                <input type="date" onChange={console.log("asger")}/>
                <input type="button" value="search" onClick={this.printDate}/>
            <Flight/>
            </div>
        )
    }
}

export default App;