import React, {Component} from 'react';
import auth from "../components/auth";

class Logout extends Component {

    logout() {
        auth.logout();
        this.props.update()
    }

    render() {
        return (
            <input type="button" value="logout" className="btn btn-createusr" onClick={this.logout.bind(this)}/>
        );
    }
}

export default Logout;
