/**
 * Created by christian on 16/05/2017.
 */
import React, {component} from 'react';
import Logo from '../img/Wowondologosmall.png';
const header = () => (
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
                        </div>
                        <div className="header-btns">
                            <a className="btn btn-travel" href="#lookup">Find a Travel</a>
                            <a className="btn btn-createusr" href="#">Create User</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
);

export default header;