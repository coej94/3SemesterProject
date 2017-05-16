import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import Logo from '../img/Wowondologosmall.png';
import auth from "../components/auth";

class header extends Component {

    logout(){
        auth.logout()
        this.props.update()
    }

    render(history) {
        return (
            <header className="header">
                <div className="header-overlay">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-12">
                                <div className="logo text-center">
                                    <img src={Logo} alt="Logo"/>
                                </div>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-md-8">
                                <div className="header-text">
                                    <h1>Welcome to Wowondo</h1>
                                    <p>FLY HIGHER!</p>
                                    <p>ANYTIME - ANYWHERE</p>
                                {auth.loggedIn ? "You are logged in as:" + auth.userName : ""}
                                </div>
                                <div className="header-btns">
                                    <NavLink to="/" className="btn btn-travel">Find a Travel</NavLink>
                                    <NavLink to="/login" className="btn btn-createusr">Login</NavLink>
                                    <NavLink to="/history" className="btn btn-createusr">Flight History</NavLink>
                                    <button className="btn btn-createusr" onClick={this.logout.bind(this)} >Logout</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
        )
    }
}

export default header;