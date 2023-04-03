import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import './components/RecipeGallery';
import './components/RecipeCard';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import axios from "axios";
import RecipeGallery from "./components/RecipeGallery";
import {Recipe} from "./model/Recipe";

function App() {
    const [recipes, setRecipes] = useState<Recipe[]>([])

    return (
        <BrowserRouter>
            <div className="App">
                <h1>Testhead</h1>
                <Routes>
                    <Route path="/" element={<RecipeGallery recipes={recipes}/>}/>
                </Routes>

            </div>
        </BrowserRouter>
    );
}

export default App;
