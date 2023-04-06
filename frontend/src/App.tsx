import React, {useState, useEffect} from 'react';
import './App.css';
import './components/RecipeGallery';
import './components/RecipeCard';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import axios from "axios";
import RecipeGallery from "./components/RecipeGallery";
import {NewRecipe, Recipe} from "./model/Recipe";
import AddRecipe from "./components/AddRecipe";

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

    function addRecipe(recipeToAdd: string ) {
        const sendRecipe: NewRecipe = {
            name: recipeToAdd,
            category: "ASIAN"
        }
        axios.post("/api/recipes", sendRecipe)
            .then((addRecipeResponse) => {

                setRecipes([...recipes, addRecipeResponse.data])
            })
            .catch((error) => {
                error("Unknown Error, try again later! " + error.response.statusText, {autoClose: 10000})
            })
    }

    useEffect(() => {
        allRecipes()
    }, [])

    return (
        <BrowserRouter>
            <div className="App">
                <Routes>
                    <Route path="/" element={<RecipeGallery recipes={recipes}/>}/>

                    <Route path='/recipes/add'
                           element={<AddRecipe addRecipe={addRecipe}/>}/>
                </Routes>

            </div>
        </BrowserRouter>
    );
}

export default App;
