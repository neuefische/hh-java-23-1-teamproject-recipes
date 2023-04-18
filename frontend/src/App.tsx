import React, {useState, useEffect} from 'react';
import './App.css';
import './components/RecipeCard';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import axios from "axios";
import RecipeGallery from "./components/RecipeGallery";
import RecipeDetail from './components/RecipeDetail';
import LoginPage from "./components/LoginPage";
import Header from "./components/Header";
import useUser from "./components/useUser";
import {NewRecipe, Recipe} from "./model/Recipe";
import AddRecipe from "./components/AddRecipe";
import UpdateRecipe from "./components/UpdateRecipe";

function App() {
    const {login} = useUser()
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

    function addRecipe(recipeToAdd: string) {
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


    function updateRecipe(recipe: Recipe) {
        axios.put(`/api/Recipe/${recipe.id}`, recipe)
            .then((putRecipeResponse) => {
                setRecipes(recipes.map(currentRecipe => {
                    if (currentRecipe.id === recipe.id) {
                        return putRecipeResponse.data
                    } else {
                        return currentRecipe
                    }
                }))
            })
            .catch(console.error)
    }

    useEffect(() => {
        allRecipes()
    }, [])

    return (
        <BrowserRouter>
            <Header/>
            <div className="App">
                <Routes>
                    <Route path="/" element={<RecipeGallery recipes={recipes}/>}/>
                    <Route path="/recipes/:id" element={<RecipeDetail/>}/>
                    <Route path="/login" element={<LoginPage onLogin={login}/>}/>
                    <Route path="/recipes" element={<RecipeGallery recipes={recipes}/>}/>
                    <Route path='/recipes/add'
                           element={<AddRecipe addRecipe={addRecipe}/>}/>
                    <Route path='/recipes/update/:id'
                           element={<UpdateRecipe updateRecipe={updateRecipe}/>}/>
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;
