import {FormEvent, useEffect, useState} from "react";
import "./AddRecipe.css"
import {Recipe} from "../model/Recipe";
import {useParams} from "react-router-dom";
import axios from "axios";

type UpdateRecipeProps = {
    updateRecipe: (newRecipe: Recipe) => void
}
export default function UpdateRecipe(props: UpdateRecipeProps) {

    const initialState: Recipe = {id: "", name: "", category: "ASIAN"}

    const [recipe, setRecipe] = useState<Recipe>(initialState)
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

    const [name, setName] = useState<string>("");

    function onSaveRecipe(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();

        if (id) {
            props.updateRecipe(recipe);
        }
    }

    return (
        <div className="updateRecipe">
            <form onSubmit={onSaveRecipe}>
                <input className="updateInput" type="text" name="name" placeholder={name} value={name}
                       onChange={(event) => {
                           setName(event.target.value)
                       }}/>

                <button className="updateBtn">Update</button>
            </form>

        </div>
    )
}