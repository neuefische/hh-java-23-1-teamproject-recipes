import {FormEvent, useState} from "react";
import "./AddRecipe.css"

type AddRecipeProps = {
    addRecipe: (newRecipe: string) => void
}
export default function AddRecipe(props: AddRecipeProps) {

    const initialState: string = ""
    const [name, setName] = useState<string>(initialState);

    function onSaveRecipe(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();

        if(name === undefined || name === '') {
            console.error("Name required")
            return
        }

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