package com.example.backend.service;

import com.example.backend.model.Category;
import com.example.backend.model.Recipe;
import com.example.backend.repo.RecipeRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    RecipeRepository recipeRepository = mock(RecipeRepository.class);
    RecipeService recipeService = new RecipeService(recipeRepository);

    @Test
    void getAllRecipesReturnEmptyList() {
        // GIVEN
        List<Recipe> expected = Collections.emptyList();
        // WHEN
        when(recipeRepository.findAll()).thenReturn(Collections.emptyList());
        List<Recipe> actual = recipeService.getAllRecipes();
        // THEN
        verify(recipeRepository).findAll();
        assertEquals(expected, actual);
    }
    @Test
    void addRecipe() {
        // GIVEN
        Recipe recipe = new Recipe("Gurke", Category.ASIAN);
        // WHEN
        when(recipeRepository.save(recipe)).thenReturn(recipe);
        Recipe actual = recipeService.addRecipe(recipe);
        // THEN
        verify(recipeRepository).save(recipe);
        assertEquals(recipe, actual);
    }

}
