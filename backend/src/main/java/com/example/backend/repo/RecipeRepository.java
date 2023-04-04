package com.example.backend.repo;

import com.example.backend.model.Category;
import com.example.backend.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {
    private final List<Recipe> recipeList;

    public RecipeRepository() {
        recipeList = new ArrayList<>();
        recipeList.add(
                new Recipe("123", "Tofu", Category.ASIAN)
        );
    }

    public List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipeList);
    }

}
