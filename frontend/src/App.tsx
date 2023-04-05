import React, {useState, useEffect, ChangeEvent} from 'react';
import './App.css';
import './components/RecipeGallery';
import './components/RecipeCard';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import axios from "axios";
import RecipeGallery from "./components/RecipeGallery";
import {Recipe} from "./model/Recipe";
import Formular from "./components/Formular";

function App() {
    const [recipes, setRecipes] = useState<Recipe[]>([])
    const [ enterName, setEnterName ] = useState<string>("")
    const onNameInputChange = (event:ChangeEvent<HTMLInputElement>) =>{
        setEnterName(event.target.value)
    }


    function allRecipes() {
        axios.get("/api/recipes")
            .then((response => {
                setRecipes(response.data)
            }))
            .catch(() => {
                console.error()
            })
    }

    useEffect(() => {
        allRecipes()
    }, []);



    return (
        <BrowserRouter>
            <div className="App">


                <Formular enterName={enterName} onNameInputChange={onNameInputChange} />

                <Routes>
                    <Route path="/" element={<RecipeGallery recipes={recipes}/>}/>
                </Routes>


            </div>
        </BrowserRouter>
    );
}

export default App;
