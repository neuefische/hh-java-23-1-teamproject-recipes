import React, {ReactNode, useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import axios from "axios";
import {Recipe} from "../model/Recipe";


function Typography(props: { children: ReactNode }) {
    return null;
}

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
            .catch((error) => {
                console.error("Recipe not found")
            })
    }
    return (
        <div>
            {
                recipe
                    ? <div>
                        <Typography>{recipe.id}</Typography>
                        <Typography>{recipe.name}</Typography>
                        <Typography>{recipe.category}</Typography>
                    </div>
                    : <div>Loading...</div>
            }

        </div>
    )
}