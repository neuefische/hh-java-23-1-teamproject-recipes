package com.example.backend.repo;

import com.example.backend.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class RecipeRepository {
    private final List<Recipe> recipeList;


    //Get Methode: To get all recipes
    public List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipeList);
    }

    public Recipe addRecipe(Recipe recipeToAdd) {
        recipeList.add(recipeToAdd);
        return recipeToAdd;
    }
/*
    //Get Methode: To get a special recipe by id
    public Recipe getRecipeById(String id) {
    for(Recipe r: recipeList){
        if (r.id().equals(id)) {

        }
    }
}*/

    //Add Methode: To add new recipe


    //Update Methode: To Edit&Update of existed recipe


    //Remove Methode: To delete a recipe by id


}
