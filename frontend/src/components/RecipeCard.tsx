import { useNavigate } from "react-router-dom";
import {Recipe} from "../model/Recipe";

type Props = {
    recipe: Recipe
}

export default function RecipeCard(props: Props){
    const navigate = useNavigate()
    return (
        <div className='recipe-card'>

            <p>{props.recipe.id}</p>
            <p>{props.recipe.name}</p>
            <p>{props.recipe.category}</p>
          <button onClick={() => {navigate('/recipes/' + props.recipe.id)}}>Detail</button>
          <button onClick={() => {navigate('/recipes/update/' + props.recipe.id)}}>Update</button>
        </div>
    )
}


