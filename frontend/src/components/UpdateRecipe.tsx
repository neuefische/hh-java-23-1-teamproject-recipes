import {ChangeEvent, FormEvent, useEffect, useState} from "react";
import "./AddRecipe.css"
import {Recipe} from "../model/Recipe";
import {useNavigate, useParams} from "react-router-dom";
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

    const navigate = useNavigate();


    function onSaveRecipe(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();

        if (id) {
            props.updateRecipe(recipe);
            navigate("/recipes")
        }
    }

    function onChange(event: ChangeEvent<HTMLInputElement>) {
        const targetName: string = event.target.name;
        const value: string = event.target.value;
        if (id) {
            setRecipe(
                {...recipe, id: id, [targetName]: value}
            )
        }
    }


    return (
        <div className="updateRecipe">
            <form onSubmit={onSaveRecipe}>
                <input className="updateInput" type="text" name="name" placeholder={recipe.name} value={recipe.name}
                       onChange={onChange}/>
                <input className="updateInput" type="text" name="category" placeholder={recipe.category}
                       value={recipe.category}
                       onChange={onChange}/>
                <button className="updateBtn">Update</button>
            </form>
        </div>
    )
}