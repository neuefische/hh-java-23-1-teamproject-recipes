package com.example.backend.service;

import com.example.backend.model.Recipe;
import com.example.backend.repo.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }


    public Recipe addRecipe(Recipe recipe) {
        Recipe recipeToSave = recipe.withId(recipe.id());
        return recipeRepository.save(recipeToSave);
    }
}