import {Recipe} from "../model/Recipe";
import RecipeCard from "./RecipeCard";


type Props = {
    recipes: Recipe[]
}

export default function RecipeGallery(props: Props) {
    return(
    <div className='recipe-gallery'>
        <div>
            <h2>All Recipes</h2>
            {
                props.recipes.map((recipe)=> <RecipeCard key={recipe.id}
                                                        recipe={recipe}/>)
            }
        </div>


    </div>
)
}