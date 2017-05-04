//Add imports here
import {observable, computed, action} from  "mobx";
import app from "../App"

class FlightStore {
    @observable _flights = [];
    constructor() {
        this.getDate();
        console.log(app.getDate())
    }

    @computed get flights() {
        return this._flights;
    }

    @action
    getDate = (dest,date,passengers) => {
        //Observer how we store a reference to the outer this
        var me = this;
        fetch("http://localhost:8084/seedMaven/api/demoall/CPH/2017-05-06T00:00:00.000Z/1").then(function (response) {
            return response.json();
        }).then(function (data) {
            //me._persons = data; This is how we did it on a normal array
            me._flights.replace(data); //replace is a mobx method, this is how we MUST do it on a mobx array
        });
    }
}

export default new FlightStore();