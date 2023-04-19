import {Recipe} from "../model/Recipe";
import RecipeCard from "./RecipeCard";


type Props = {
    recipes: Recipe[]
    updateRecipe:(recipe:Recipe)=>void
    deleteRecipe: (id: string) => void
}

export default function RecipeGallery(props: Props) {
    return(
    <div className='recipe-gallery'>
        <div>
            <h2>All Recipes</h2>
            {
                props.recipes.map((recipe)=> <RecipeCard key={recipe.id}
                                                         deleteRecipe={props.deleteRecipe} recipe={recipe} updateRecipe={props.updateRecipe}/>)
            }
        </div>
        </div>
    )
}