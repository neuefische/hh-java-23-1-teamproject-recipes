import {Recipe} from "../model/Recipe";

type Props = {
    recipe: Recipe
}

export default function RecipeCard(props: Props){
    return (
        <div className='recipe-card'>
            <p>{props.recipe.id}</p>
            <p>{props.recipe.name}</p>
            <p>{props.recipe.image}</p>
            <p>{props.recipe.ingredients}</p>
            <p>{props.recipe.preparation}</p>
            <p>{props.recipe.portions}</p>
            <p>{props.recipe.categories}</p>
        </div>
    )
}