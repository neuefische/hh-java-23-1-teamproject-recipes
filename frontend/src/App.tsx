import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter} from "react-router-dom";
import axios from "axios";

function App() {
  const [data, setData] = useState("");

  useEffect(() => {
    axios.get("/api/test")
        .then(response => {
          setData(response.data);
        })
        .catch(error => {
          console.log(error);
        });
  }, []);
  return (
      <BrowserRouter>
    <div className="App">
      <h1>Testhead</h1>
      <p>{data}</p>
     {/* <Routes>
        <Route>

        </Route>
      </Routes>*/}


    </div>
      </BrowserRouter>
  );
}

export default App;
