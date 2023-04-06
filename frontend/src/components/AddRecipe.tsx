import {FormEvent, useState} from "react";
import {NewRecipe, Recipe} from "../model/Recipe";
import axios from "axios";
import "./AddRecipe.css"
import {useNavigate} from "react-router-dom";

type AddRecipeProps = {
    addRecipe: (newRecipe: string) => void
}
export default function AddRecipe(props: AddRecipeProps) {

    const initialState: string = ""
    const [name, setName] = useState<string>(initialState);

    const navigate = useNavigate();

    function onSaveRecipe(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();
        // const newRecipe: NewRecipe = {name: 'Recipe Name', category: "ASIAN"};
        /*axios
            .post('/api/recipes', newRecipe)
            .then(response => {
                const recipe: Recipe = {...response.data, id: response.data.id};
                props.addRecipe(recipe);
                setName('');
                navigate('/recipes');
            })
            .catch(console.error);*/
        props.addRecipe(name);
    }

    return (
        <div className="addRecipe">
            <form onSubmit={onSaveRecipe}>
                <input className="addInput" type="text" name="name" value={name} onChange={(event) => {
                    setName(event.target.value)
                }}/>

                <button className="addBtn">Add</button>
            </form>

        </div>
    )
}