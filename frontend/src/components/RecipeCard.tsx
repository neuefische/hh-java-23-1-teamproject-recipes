import {useNavigate} from "react-router-dom";
import {Recipe} from "../model/Recipe";

type Props = {
    updateRecipe: (recipe:Recipe) => void
    recipe: Recipe,
    deleteRecipe: (id: string) => void
}

export default function RecipeCard(props: Props) {
    const navigate = useNavigate()

    function onDeleteClick() {
        props.deleteRecipe(props.recipe.id)
    }

    return (
        <div className='recipe-card'>

            <p>{props.recipe.id}</p>
            <p>{props.recipe.name}</p>
            <p>{props.recipe.category}</p>
            <button onClick={() => {
                navigate('/recipes/' + props.recipe.id)
            }}>Detail
            </button>
            <button onClick={() => {
                navigate('/recipes/update/' + props.recipe.id)
            }}>Update
            </button>
            <button onClick={() => {
                navigate('/recipes/' + props.recipe.id)
            }}>Detail
            </button>

            <button className="deleteBtn" onClick={onDeleteClick}>Delete</button>

        </div>
    )
}


