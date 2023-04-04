import {Recipe} from "../model/Recipe";

type Props = {
    recipe: Recipe
}

export default function RecipeCard(props: Props){
    return (
        <div className='recipe-card'>
            <p>{props.recipe.id}</p>
            <p>{props.recipe.name}</p>
            <p>{props.recipe.category}</p>
        </div>
    )
}