import axios from "axios";

//Cors issue?
export default axios.create({
    // baseURL: "http://127.0.0.1:8080",
    baseURL: "http://localhost:3000",
    headers: {
        "Content-type": "application/json"
    }
})