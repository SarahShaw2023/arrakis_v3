import React from "react";
import "./App.css";
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { useState } from 'react'

import Home from "./components/Home";
import Login from "./components/Login";
import ResetLogin from "./components/ResetLogin";
import AccountCreation from "./components/AccountCreation";
import Layout from "./components/Layout";

const App = () => {
  const [userID, setUserID] = useState(0)

  return (
    <div className="App">
      <Layout>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Login userID={userID} setUserID={setUserID} />} />
            <Route path="/login" element={<Login userID={userID} setUserID={setUserID} />} />
            <Route path="/home" element={<Home userID={userID} setUserID={setUserID} />} />
            <Route path="/resetLogin" element={<ResetLogin />} />
            <Route path="/createAccount" element={<AccountCreation />} />
          </Routes>
        </BrowserRouter>
      </Layout>
    </div>
  );
};

export default App;
