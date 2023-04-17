import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import axios from "axios";
import {Recipe} from "../model/Recipe";

export default function TodoDetail() {

    const [recipe, setRecipe] = useState<Recipe>()
    const {id} = useParams<{ id: string }>()

    useEffect(() => {
        if (id) {
            loadRecipeById(id)
        }
    }, [])

    function loadRecipeById(id: string) {
        axios.get('/api/recipes/' + id)
            .then((response) => {
                setRecipe(response.data)
            })
            .catch((r) => {
                console.error("Recipe not found" + r)
            })
    }

    return (
        <div>
            {
                recipe
                    ? <div>
                        <p>{recipe.id}</p>
                        <p>{recipe.name}</p>
                        <p>{recipe.category}</p>
                    </div>
                    : <div>Loading...</div>
            }

        </div>
    )
}