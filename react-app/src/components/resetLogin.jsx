import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {updateUser} from '../services/TradeServices'

import CryptLogic from "../utils/crypt";

const ResetLogin = () => {
    //User account info
    const [email, setEmail] = useState("")
    const [username, setUsername] = useState("")
    //New password to use
    const [password, setPassword] = useState("")
    //Notifies user of: info processing (api call in progress), error, and success
    const [accCreateMsg, setAccCreateMsg] = useState("")

    const navigate = useNavigate;
    
    const onBackLoginPage = () => {
        // Return user to login page
        // in order to retry with new login credentials

        //TODO: fix does not work
        // navigate('/login');
        window.location.replace('/login');
    }

    const onSubmitReset = () => {
        setAccCreateMsg("")

        //Do an api call to check if email/username is valid
        setAccCreateMsg("Please wait. Searching matching account in progress...")

        //Encrypt password
        let pwd = CryptLogic.encryptStr(password); //password
        updateUser(email, username, pwd)
            .then(res => {
                console.log("updateUser data: " + res.data);
                let result = res.data; //int

                if(result > 0) {
                    setEmail("")
                    setUsername("")
                    setPassword("")

                    setAccCreateMsg("Password successfully updated. Redirecting to login page in 3 seconds....")
                    setTimeout(function() {
                        window.location.replace('/login');
                        }, 3000);
                }
                else if(result === -1) {
                    setEmail("")
                    setUsername("")
                    setAccCreateMsg("Error: Invalid email and username")
                }

                else if(result === 0) {
                    setUsername("")
                    setAccCreateMsg("Error: Invalid username")
                }
                //result == -2
                else {
                    //All params valid but update action failed
                    setAccCreateMsg("Error: Unable to update password.\n Please try again.");
                }
            })
            .catch(err => {
                console.log("updateUser err: " + err);
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
                <div>Reset password</div>
            </div>
            <div className={"inputContainer"}>
                <label className={"inputLabel"}>Enter in email associated with account:</label>
                <input
                    value={email}
                    placeholder="Email"
                    onChange={ev => setEmail(ev.target.value)}
                    className={"inputBox"} />
                
            </div>
            <div className={"inputContainer"}>
                <label className={"inputLabel"}>Enter in username associated with account:</label>
                <input
                    value={username}
                    placeholder="Username"
                    onChange={ev => setUsername(ev.target.value)}
                    className={"inputBox"} />
                
            </div>
            <div className={"inputContainer"}>
                <label className={"inputLabel"}>Enter in new password:</label>
                <input
                    value={password}
                    placeholder="New password"
                    onChange={ev => setPassword(ev.target.value)}
                    className={"inputBox"} />
                
            </div>
            <div className={"inputContainer"}>
                <input
                    className={"mainButton inputButton"}
                    type="button"
                    onClick={onSubmitReset}
                    value={"Submit"} />
            </div>
            <label className="errorLabel">{accCreateMsg}</label>
        </div>
    );
};

export default ResetLogin;