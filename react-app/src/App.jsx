import React from "react";
import "./App.css";
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { useState } from 'react';
import Home from "./components/Home";
import Login from "./components/Login";

const App = () => {
  const [userID, setUserID] = useState(0)

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<Login userID={userID} setUserID={setUserID} />} />
          <Route path="/home" element={<Home userID={userID} setUserID={setUserID} />} />
        </Routes>
      </BrowserRouter>
    </div>);
};

export default App;
