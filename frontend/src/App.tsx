import React, {useState, useEffect} from 'react';
import './App.css';
import './components/RecipeGallery';
import './components/RecipeCard';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import axios from "axios";
import RecipeGallery from "./components/RecipeGallery";
import {Recipe} from "./model/Recipe";
import LoginPage from "./components/LoginPage";
import Header from "./components/Header";
import useUser from "./components/useUser";

function App() {
    const { user, login } = useUser()
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
            <Header />
            <div className="App">
                <Routes>
                    <Route path="/login" element={<LoginPage onLogin={login} />}/>
                    <Route path="/recipes" element={<RecipeGallery recipes={recipes}/>}/>
                </Routes>

            </div>
        </BrowserRouter>
    );
}

export default App;
