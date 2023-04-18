import {Recipe} from "../model/Recipe";
import RecipeCard from "./RecipeCard";


type Props = {
    recipes: Recipe[],
    deleteRecipe: (id: string) => void
}

export default function RecipeGallery(props: Props) {
    return (
        <div className='recipe-gallery'>
            <div className="recipe-gallery_column">
                <h2>All Recipes</h2>
                {
                    props.recipes.map((recipe) => <RecipeCard key={recipe.id}
                                                              recipe={recipe}
                                                              deleteRecipe={props.deleteRecipe}

                    />)
                }
            </div>


        </div>
    )
}