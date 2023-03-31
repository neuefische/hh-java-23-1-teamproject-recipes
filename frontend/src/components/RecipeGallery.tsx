import {Recipe} from "../model/Recipe";


type Props = {
    recipes: Recipe[],
    updateRecipe: (recipe: Recipe) => void,
    deleteRecipe: (id: string) => void
}
export default function RecipeGallery(props: Props) {
    return(
    <div>
        <h1>Recipe Gallery</h1>
    </div>
)
}