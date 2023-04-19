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
import ProtectedRoutes from "./ProtectedRoutes";

function App() {
    const {user, login} = useUser()
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

    useEffect(() => {
        allRecipes()
    }, []);


    function deleteRecipe(id: string) {
        axios.delete('/api/recipes/' + id)
            .then(() => {
                setRecipes(recipes.filter((recipe) => recipe.id !== id))
            })
            .catch(console.error)
    }


    return (
        <BrowserRouter>
            <Header user={user}/>
            <div className="App">
                <Routes>
                    <Route path="/login" element={<LoginPage onLogin={login}/>}/>
                    <Route element={<ProtectedRoutes user={user}/>}>
                        <Route path="/" element={<RecipeGallery recipes={recipes} deleteRecipe={deleteRecipe}/>}/>
                    <Route path="/recipes/:id" element={<RecipeDetail/>}/>
                    <Route  path="/recipes" element={<RecipeGallery recipes={recipes} deleteRecipe={deleteRecipe}/>}/>
                    </Route>
                    <Route path='/recipes/add'
                           element={<AddRecipe addRecipe={addRecipe}/>}/>
                </Routes>

            </div>
        </BrowserRouter>
    );
}

export default App;
