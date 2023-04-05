package com.example.backend.repo;

import com.example.backend.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {
    private final List<Recipe> recipeList;

    public RecipeRepository() {
        recipeList = new ArrayList<>();
    }

    public List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipeList);
    }


    public Recipe addRecipe(Recipe recipe) {
        recipeList.add(recipe);
        return recipe;
    }

}
