import React, {Component} from 'react';
import auth from "../components/auth";

class Logout extends Component {

    logout() {
        auth.logout();
    }

    render() {
        return (
            <div className="container">
                <input type="button" value="logout" onClick={this.logout.bind(this)}/>
            </div>
        );
    }
}

export default Logout;
