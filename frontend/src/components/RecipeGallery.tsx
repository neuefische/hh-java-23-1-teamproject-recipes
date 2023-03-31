import {Recipe} from "../model/Recipe";
import RecipeCard from "./RecipeCard";


type Props = {
    recipes: Recipe[]
}

export default function RecipeGallery(props: Props) {
/*    const asianRecipes: Recipe[] = props.recipes.filter((recipe)=> recipe.categories === 'ASIAN')
    const europeanRecipes: Recipe[] = props.recipes.filter((recipe)=> recipe.categories === 'EUROPEAN')
    const mediterraRecipes: Recipe[] = props.recipes.filter((recipe)=> recipe.categories === 'MEDITERRANEAN')*/
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