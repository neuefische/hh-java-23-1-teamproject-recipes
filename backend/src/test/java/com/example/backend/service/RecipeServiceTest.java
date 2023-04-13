package com.example.backend.service;

import com.example.backend.model.Category;
import com.example.backend.model.Recipe;
import com.example.backend.repo.RecipeRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @Test
    void getRecipeById() {
        // GIVEN
        String id = "642ee1f918543010b981f729";
        Recipe expected = new Recipe(
                "642ee1f918543010b981f729",
                "Tofu",
                Category.ASIAN
        );
        // WHEN
        when(recipeRepository.findById(id)).thenReturn(Optional.of(expected));
        Optional<Recipe> actual = recipeService.getRecipeById(id);
        // THEN
        verify(recipeRepository).findById(id);
        assertEquals(expected, actual.get());
    }

    @Test
    void getRecipeById_whenRecipeNotExist_thenReturnException() {
        // GIVEN
        String id = "123567";
        // WHEN
        when(recipeRepository.findById(id)).thenThrow(new NoSuchElementException());
        // THEN
        assertThrows(NoSuchElementException.class, () -> recipeService.getRecipeById(id));
    }
}
