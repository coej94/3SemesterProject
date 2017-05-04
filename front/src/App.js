import React, {Component} from 'react'
import FlightTable from './components/FlightTable'
class App extends Component {


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

                <input type="date" onChange={this.handleChange.bind(this)}/>
                <FlightTable data={this.state.date}/>
            </div>
        )
    }
}

export default App;