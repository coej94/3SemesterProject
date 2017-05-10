import React, {Component} from 'react';
import auth from "../components/auth";
import Logout from './Logout';

class Login extends Component {

    state = {
        username: "",
        password: "",
        loggedIn: false
    }

    handleSubmit(event) {
        event.preventDefault()
        auth.login(this.state.username, this.state.password, (loggedIn) => {
            this.setState({loggedIn:true}) // Let's rerender!!!!!!!!!!!!!
            console.log(this.state)
        });
    }

    handleChange(e) {
        this.setState({
            [e.target.name]: e.target.value
        }, () => console.log())
    }

    render() {
        return (
                <div className="container">
                    <form className="form-signin" onSubmit={this.handleSubmit.bind(this)}>
                        <h2 className="form-signin-heading">Please sign in</h2>
                        <input type="text" name="username" className="form-control"
                               onChange={this.handleChange.bind(this)}/>
                        <br/>
                        <input type="password" name="password" className="form-control"
                               onChange={this.handleChange.bind(this)}/>
                        <br/>
                        <button className="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    </form>
                    {auth.loggedIn ? "Logged in: true" : "Logged in: false"}

                    <Logout/>

                </div>
        );
    }
}

export default Login;
