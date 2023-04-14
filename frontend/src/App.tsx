import React, {useState, useEffect} from 'react';
import './App.css';
import './components/RecipeGallery';
import './components/RecipeCard';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import axios from "axios";
import RecipeGallery from "./components/RecipeGallery";
import {Recipe} from "./model/Recipe";
import RecipeDetail from './components/RecipeDetail';

function App() {
    const [recipes, setRecipes] = useState<Recipe[]>([])

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
    }, [])

    return (
        <BrowserRouter>
            <div className="App">
                <Routes>
                    <Route path="/" element={<RecipeGallery recipes={recipes}/>} />
                    <Route path="/recipes/:id" element={<RecipeDetail/>} />
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;
