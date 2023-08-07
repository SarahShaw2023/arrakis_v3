import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {createAcc} from '../services/TradeServices'

import CryptLogic from "../utils/crypt";

const AccountCreation = () => {
    //User account info
    const [email, setEmail] = useState("")
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [role, setRole] = useState("")
    //Notifies user of: info processing (api call in progress), error, and success
    const [accCreateMsg, setAccCreateMsg] = useState("")

    const navigate = useNavigate;

    
    const onBackLoginPage = () => {
        // Return user to login page
        // in order to log in

        //TODO: fix does not work
        // navigate("/login");

        window.location.replace('/login');
    }

    const onSubmit = () => {
        setAccCreateMsg("")

        //Do an api call to check if email/username is valid
        setAccCreateMsg("Please wait. Attempting account creation...")

        //Encrypt password
        let pwd = CryptLogic.encryptStr(password); //password
        createAcc(email, username, pwd, role)
            .then(res => {
                console.log("createAcc data: " + res.data);
                let result = res.data; //bool

                if(result) {
                    setAccCreateMsg("Account successfully made. Redirecting to login page in 3 seconds...")
                    setTimeout(function() {
                        window.location.replace('/login');
                        }, 3000);
                }
                else {
                    setAccCreateMsg("Invalid params (blank) or an account already exists with that email.")
                }
                
            })
            .catch(err => {
                console.log("createAcc err: " + err);
                setAccCreateMsg("An unexpected issue occured.\nPlease try again")
            });

    }

    return (
        <div className={"mainContainerLeft"}>
            <div className={"containerRight"}>
                <input
                    className={"backButton"}
                    type="button"
                    onClick={onBackLoginPage}
                    value={"Back"} />
            </div>
            <div className={"titleContainer"}>
                <div>Create Account</div>
            </div>
            <div className={"inputContainer"}>
                <label className={"inputLabel"}>Email:</label>
                <input
                    value={email}
                    placeholder="Email"
                    onChange={ev => setEmail(ev.target.value)}
                    className={"inputBox"} />
                
            </div>
            <div className={"inputContainer"}>
                <label className={"inputLabel"}>Username:</label>
                <input
                    value={username}
                    placeholder="Username"
                    onChange={ev => setUsername(ev.target.value)}
                    className={"inputBox"} />
                
            </div>
            <div className={"inputContainer"}>
                <label className={"inputLabel"}>Role:</label>
                <input
                    value={role}
                    placeholder="Role"
                    onChange={ev => setRole(ev.target.value)}
                    className={"inputBox"} />
                
            </div>
            <div className={"inputContainer"}>
                <label className={"inputLabel"}>Password:</label>
                <input
                    value={password}
                    placeholder="(must be greater than 8 letters)"
                    onChange={ev => setPassword(ev.target.value)}
                    className={"inputBox"} />
                
            </div>
            <div className={"inputContainer"}>
                <input
                    className={"mainButton inputButton"}
                    type="button"
                    onClick={onSubmit}
                    value={"Submit"} />
            </div>
            <label className="errorLabel">{accCreateMsg}</label>
        </div>
    );
};

export default AccountCreation;