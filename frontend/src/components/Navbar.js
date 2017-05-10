import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';

class Navbar extends Component {
    render() {
        return (
            <nav className="navbar navbar-default ">
                <div className="container">

                    <div className="navbar-header">
                        <NavLink exact to="/">
                            <span className="navbar-brand">Wowondo</span>
                        </NavLink>
                        <ul className="nav navbar-nav">
                            <li><NavLink exact activeClassName="isActive" to="/">Forside?</NavLink></li>
                            <li><NavLink activeClassName="active" to="/test/">Opret bruger?</NavLink></li>
                            <li><NavLink to="/Admin">Admin Page</NavLink></li>
                            <li><NavLink to="/Login">Login</NavLink></li>
                        </ul>
                    </div>
                </div>
            </nav>
        );
    }
}

export default Navbar;