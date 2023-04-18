import {Recipe} from "../model/Recipe";
import RecipeCard from "./RecipeCard";


type Props = {
    recipes: Recipe[]
    updateRecipe:(recipe:Recipe)=>void
}

export default function RecipeGallery(props: Props) {
    return(
    <div className='recipe-gallery'>
        <div>
            <h2>All Recipes</h2>
            {
                props.recipes.map((recipe)=> <RecipeCard key={recipe.id}
                                                        recipe={recipe} updateRecipe={props.updateRecipe}/>)
            }
        </div>


    </div>
)
}