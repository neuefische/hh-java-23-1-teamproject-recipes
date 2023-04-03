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

}
